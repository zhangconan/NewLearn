package com.zkn.newlearn.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zkn on 2017/3/22.
 */
public class SelectSocketsThreadPool extends SelectSocketLearnFirst {

    private static final int MAX_THREADS = 5;
    private ThreadPool pool = new ThreadPool(MAX_THREADS);

    public static void main(String[] args) throws Exception {
        new SelectSocketsThreadPool().go(args);
    }

    protected void readDataFromSocket(SelectionKey key) throws Exception {
        WorkerThread worker = pool.getWorker();
        if (worker == null) {
            return;
        }
        worker.serviceChannel(key);
    }
}

class ThreadPool {
    List<WorkerThread> idle = new LinkedList<>();

    ThreadPool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            WorkerThread thread = new WorkerThread(this);
            thread.setName("Worker" + (i + 1));
            thread.start();
            idle.add(thread);
        }
    }

    WorkerThread getWorker() {
        WorkerThread worker = null;
        synchronized (idle) {
            if (idle.size() > 0) {
                worker = idle.remove(0);
            }
        }
        return worker;
    }

    void returnWorker(WorkerThread worker) {
        synchronized (idle) {
            idle.add(worker);
        }
    }
}

class WorkerThread extends Thread {

    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private ThreadPool pool;
    private SelectionKey key;

    WorkerThread(ThreadPool pool) {
        this.pool = pool;
    }

    @Override
    public synchronized void run() {
        System.out.println(this.getName() + " is ready ");
        while (true) {
            try {
                this.wait();
            } catch (Exception e) {
                this.isInterrupted();
            }
            if (key == null) {
                continue;
            }
            System.out.println(this.getName() + " has been awakened ");
            try {
                drainChannel(key);
            } catch (Exception e) {
                System.out.println("Caught'" + e + "' closing channel ");
                try {
                    key.channel().close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                key.selector().wakeup();
            }
            key = null;
            this.pool.returnWorker(this);
        }
    }

    synchronized void serviceChannel(SelectionKey key) {
        this.key = key;
        key.interestOps(key.interestOps() & ~SelectionKey.OP_READ);
        this.notify();
    }

    void drainChannel(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            buffer.clear();
        }
        if (count < 0) {
            channel.close();
            return;
        }
        key.interestOps(key.interestOps() | SelectionKey.OP_READ);
        key.selector().wakeup();
    }
}
