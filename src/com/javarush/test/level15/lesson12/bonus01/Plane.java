package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Timur on 27.03.2016.
 */
public class Plane implements Flyable
{
    private int quant;
    public void fly() {}

    public Plane(int quant)
    {
        this.quant = quant;
    }
}
