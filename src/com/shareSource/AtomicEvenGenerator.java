package com.shareSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by newland on 2017/9/1.
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger();
    public int next(){
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String []args ){
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
