package com.deadLock;

/**
 * Created by 拽拽鑫 on 2017/9/3.
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException{
        while(taken)
            wait();
        taken = true;
    }
    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}
