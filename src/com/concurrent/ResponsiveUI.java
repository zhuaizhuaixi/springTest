package com.concurrent;

import javax.swing.*;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
 class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception{
        while(d<0)
            d=d+(Math.PI + Math.E)/d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread{
     private static volatile double d =1;
     public ResponsiveUI(){
         setDaemon(true);
         start();
     }
     public void run(){
         while(true){
             d=d+(Math.PI+ Math.E)/d;
         }
     }
     public static void main(String [] args)throws Exception{
         new ResponsiveUI();
         System.in.read();
         System.out.println(d);
     }
}


