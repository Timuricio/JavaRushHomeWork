package com.javarush.test.level21.lesson16.big01;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Created by Timur on 09.04.2016.
 */
public class Horse
{
    private String name;
    private double speed, distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }


    public void move() {
        this.distance += this.speed*Math.random();
    }

    public void print() {
        int quantityDot = (int) Math.round(this.distance);
        for(int i =0;i<quantityDot;i++)
        {
            System.out.print(".");
        }

        System.out.println(this.getName());
    }
}
