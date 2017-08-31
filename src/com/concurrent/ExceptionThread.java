package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
public class ExceptionThread implements Runnable {
    public void run(){
        throw new RuntimeException();
    }
    public static void main(String [] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
