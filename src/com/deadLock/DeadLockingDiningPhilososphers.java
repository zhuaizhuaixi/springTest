package com.deadLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 拽拽鑫 on 2017/9/3.
 */
public class DeadLockingDiningPhilososphers  {
    public static void main(String[] args) throws  Exception{
        int ponder=5;
        ponder = 0;
        int size =5;
        size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick [] sticks = new Chopstick[size];
        for (int i = 0; i < size ; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i],sticks[(i+1)%size],i,ponder));
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
