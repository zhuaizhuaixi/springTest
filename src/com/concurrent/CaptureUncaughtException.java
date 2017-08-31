package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
class ExceptionThread2 implements Runnable {
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run() by "+t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t,Throwable e){
        System.out.println("caught "+e);
    }
}

class HandlerThreadFactroy implements ThreadFactory{
    public Thread newThread(Runnable r){
        System.out.println(this+"creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException{
    public static void main(String [] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactroy());
        exec.execute(new ExceptionThread2());
    }
}