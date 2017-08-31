package com.zzx;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
/**
 * Created by 拽拽鑫 on 2017/7/30.
 */
public class LiftOff implements  Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
    }
    public void run(){
        while(countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }


 //   public static  void main (String [] args) throws IOException, ClassNotFoundException {

      /*  ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        HelloWorld helloworld = (HelloWorld) context.getBean("helloWorld");

        helloworld.sayHello();*/
//        ConcurrentHashMap
//        Vector;
//        List;
//        HashMap;
//        PriorityQueue
//        Hashtable;
//        Stream



  //  }
}
