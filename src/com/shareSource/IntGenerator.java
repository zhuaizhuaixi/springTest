package com.shareSource;

/**
 * Created by newland on 2017/9/1.
 */
public abstract class IntGenerator  {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){canceled=true;}
    public boolean isCanceled(){return canceled;}

}
