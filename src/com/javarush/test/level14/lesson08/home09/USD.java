package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Timur on 23.03.2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName() {
        return "USD";
    }
}
