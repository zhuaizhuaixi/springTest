package com.concurrent.Utils;

import java.util.concurrent.ThreadFactory;

/**
 * Created by 拽拽鑫 on 2017/8/31.
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread (Runnable r){
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
