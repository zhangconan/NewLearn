package com.zkn.newlearn.thread.threadpool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by wb-zhangkenan on 2017/2/4.
 */
public class GetFileSize02 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<Long>> futures = Files.list(new File("D:/").toPath())
                    .filter(s -> !s.toFile().isDirectory())
                    .map(s -> new Callable<Long>() {
                        @Override
                        public Long call() throws Exception {
                            System.out.println(s);
                            return Files.size(s);
                        }
                    })
                    .map(c -> executorService.submit((Callable<Long>) c))
                    .collect(Collectors.toList());

            Supplier<LongStream> streamSupplier = () ->
                    futures.stream().map(f -> {
                        try {
                            return f.get();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return -1;
                        }
                    })
                            .mapToLong(val -> (Long) val);

            streamSupplier.get().forEach(System.out::println);
            System.out.println("total:" + streamSupplier.get().sum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
