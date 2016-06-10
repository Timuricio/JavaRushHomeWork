package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Timur on 25.03.2016.
 */
public class Moon implements Planet
{
    private static final Moon instance = new Moon();

    private Moon()
    {
    }

    public static Moon getInstance() {
        return instance;
    }
}
