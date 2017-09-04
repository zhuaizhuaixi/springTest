package com.shutDown;

import com.concurrent.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by 拽拽鑫 on 2017/9/3.
 */
class LiftOffRunner implements  Runnable{
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }
    public void add(LiftOff lo){
        try{
            rockets.put(lo);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }catch (InterruptedException e){
            System.out.println("waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
public class TestBlockQueues {
    static void getKey(){
        try{
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getKey(String message){
        System.out.println(message);
        getKey();
    }
    static void test(String msg,BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread (runner);
        t.start();
        for(int i=0;i<5;i++){
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter'("+msg+")");
        t.interrupt();
        System.out.println("Finished "+msg + "test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<LiftOff>());
        Map m = new HashMap<>();
        m.put("1","2");

    }
}
