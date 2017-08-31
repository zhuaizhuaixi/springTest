package com.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 拽拽鑫 on 2017/8/30.
 */
public class SleepingTask extends LiftOff {
    public void run(){
        try{
            while(countDown-->0){
                System.out.println(status());
                TimeUnit.MICROSECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
    public static void main(String []args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
