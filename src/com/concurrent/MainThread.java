package com.concurrent;

import sun.applet.Main;

/**
 * Created by 拽拽鑫 on 2017/8/29.
 */
public class MainThread {
    public static void main (String [] args){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
