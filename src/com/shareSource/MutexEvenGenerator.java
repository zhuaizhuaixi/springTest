package com.shareSource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by newland on 2017/9/1.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue=0;
    private Lock lock = new ReentrantLock();
    public int next(){
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String [] args){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
