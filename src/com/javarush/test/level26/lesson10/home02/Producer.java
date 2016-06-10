package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Timur on 17.05.2016.
 */
public class Producer implements Runnable
{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try
        {
            int i = 1;
            while (true)
            {
                System.out.println("Some text for "+i++);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.printf("%s  thread was terminated\n", Thread.currentThread().getName());
        }
    }
}
