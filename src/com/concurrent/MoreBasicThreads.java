package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 拽拽鑫 on 2017/8/29.
 */
public class MoreBasicThreads {
    public static void main (String [] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0 ;i<5;i++)
            exec.execute(new LiftOff());
        System.out.print("Waiting for LiftOff");
    }
}
