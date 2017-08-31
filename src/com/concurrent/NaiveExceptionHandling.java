package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
public class NaiveExceptionHandling {
    public static void main(String[] args ){
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (RuntimeException ue){
            System.out.println("Exception has been handled!");
        }
    }
}
