package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
class ADaemon implements Runnable{
    public void run(){
        try{
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally{
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally  {
    public static void main(String [] args) throws Exception{
        Thread t = new Thread(new ADaemon());
    //    t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
    }
}
