package com.shareSource;

/**
 * Created by newland on 2017/9/1.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber =0;
    public static synchronized int nextSerialNumber(){
        return serialNumber++;
    }
}
