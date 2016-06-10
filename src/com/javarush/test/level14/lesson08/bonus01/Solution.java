package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------2----------------------
        try
        {
            int[] i = new int[2];
            i[4] = 2;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------3----------------------
        try
        {
            System.clearProperty(null);


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------4----------------------
        try
        {
            InputStream input = new FileInputStream("D:\\bnbnvf.txt");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------5----------------------
        try
        {
            InputStream input = new FileInputStream("D:\\java.txt");
            input.close();
            input.read();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------6----------------------
        try
        {
            int i = Integer.parseInt("nbv");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------4----------------------
        try
        {
            InputStream input = new FileInputStream("D:\\bnbnvf.txt");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------5----------------------
        try
        {
            InputStream input = new FileInputStream("D:\\java.txt");
            input.close();
            input.read();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------6----------------------
        try
        {
            int i = Integer.parseInt("nbv");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------------6----------------------
        try
        {
            int i = Integer.parseInt("nbv");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here

    }
}
