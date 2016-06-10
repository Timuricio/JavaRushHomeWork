package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Timur on 12.05.2016.
 */
public class MyThread extends Thread
{
    private static int priority = 0;

    //*********************Constructors************************
    public MyThread()
    {
        init();
    }

    public MyThread(Runnable target)
    {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        init();
    }

    public MyThread(String name)
    {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        init();
    }

    //*************************************************************************************

    private void init()
    {
        if (MyThread.priority==10)
            MyThread.priority=0;
        if (this.getThreadGroup()!=null&&MyThread.priority>this.getThreadGroup().getMaxPriority())
        {
            this.setPriority(this.getThreadGroup().getMaxPriority());
            ++priority;
        }
        else
            this.setPriority(++priority);
    }


}
