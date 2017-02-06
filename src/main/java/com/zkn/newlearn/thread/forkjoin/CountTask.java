package com.zkn.newlearn.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wb-zhangkenan on 2017/2/6.
 */
public class CountTask extends RecursiveTask<Integer> {
    //创建一个阀值
    private static final int THRESHOLD = 2;
    //任务开始的区间值
    private int start;
    //任务结束的区间值
    private int end;


    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        //判断任务是不是足够小
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {//如果任务足够小
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {//继续分割
            System.out.println("我被分割了一次");
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask countTask = new CountTask(1, 15);
        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            int sum = result.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        int sum1 = 0;
        for (int i = 1; i <= 12; i++) {
            sum1 += i;
        }
        System.out.println(sum1);
    }
}
