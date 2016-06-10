package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Timur on 24.03.2016.
 */
public class Singleton
{
    private static Singleton sing;

    static Singleton getInstance() {
        return Singleton.sing;
    }

    private Singleton()
    {
        Singleton.sing = new Singleton();
    }
}
