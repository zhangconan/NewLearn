package com.zkn.newlearn.thread.threadpool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zkn on 2017/1/31.
 */
public class GetTotalFileSize {

    public static void main(String[] args) throws Exception {
        System.out.println(Files.size(new File("d:\\log\\provider.log").toPath()));
        //firstSize();
    }

    private static void firstSize() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Long allSize = Files.list(new File("D:\\log").toPath())
                .filter(s -> !s.toFile().isDirectory())
                .map(s -> {
                    Future future = executorService.submit(() -> {
                        long size = Files.size(s);
                        return size;
                    });
                    Long size = null;
                    try {//拆装箱问题
                        size = (Long) future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return size;
                }).reduce(Long::sum).get();
        System.out.println(allSize);
        executorService.shutdown();
    }

}
