package com.javarush.test.level27.lesson09.home01;

public class TransferObject
{
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()
    {
        notify();
        System.out.println("Got: " + value);
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return value;

    }

    public synchronized void put(int value)
    {
        notify();
        this.value = value;
        System.out.println("Put: " + value);
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
