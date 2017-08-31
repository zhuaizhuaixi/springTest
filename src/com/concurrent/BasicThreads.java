package com.concurrent;

/**
 * Created by 拽拽鑫 on 2017/8/29.
 */
public class BasicThreads {
    public static void main (String [] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
