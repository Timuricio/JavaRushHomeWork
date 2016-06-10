package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Timur on 28.04.2016.
 */
public final class CurrencyManipulatorFactory
{
    private static Map<String ,CurrencyManipulator> mapManipulators = new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (mapManipulators.containsKey(currencyCode))
            return mapManipulators.get(currencyCode);
        else
        {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            mapManipulators.put(currencyCode,manipulator);
            return manipulator;
        }

    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return mapManipulators.values();
    }

}
