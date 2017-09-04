package com.shutDown;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by 拽拽鑫 on 2017/9/3.
 */
 class NIOBlocked implements Runnable {
    private final SocketChannel sc;
    public NIOBlocked(SocketChannel sc){
        this.sc=sc;
    }
    public void run(){
        try{
            System.out.println("waiting for read() in "+this);
            sc.read(ByteBuffer.allocate(1));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("exiting nioblocked.run() "+this);
    }
}
public class NIOInterruption {
     public static void main(String [] args)throws Exception{
         ExecutorService exec = Executors.newCachedThreadPool();
         ServerSocket server =  new ServerSocket(8080);
         InetSocketAddress isa = new InetSocketAddress("localhost",8080);
         SocketChannel sc1 = SocketChannel.open(isa);
         SocketChannel sc2 = SocketChannel.open(isa);
         Future<?> f = exec.submit(new NIOBlocked(sc1));
         exec.execute(new NIOBlocked(sc2));
         exec.shutdown();
         TimeUnit.SECONDS.sleep(1);
         f.cancel(true);
         TimeUnit.SECONDS.sleep(1);
         sc2.close();
     }
}
