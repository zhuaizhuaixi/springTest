package com.shareSource;

/**
 * Created by newland on 2017/9/1.
 */
public class SynchronizedEvenGenerator extends  IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next(){
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String [] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
