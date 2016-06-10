package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Timur on 10.05.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        boolean correct = false;
        String s = "";
        while (!correct)
        {
            try
            {
                s = reader.readLine();
                correct = true;
            }
            catch (IOException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return s;
    }

    public static int readInt()
    {
        boolean correct = false;
        int i = 0;
        while (!correct)
        {
            try
            {
                i = Integer.parseInt(readString());
                correct = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }

        return i;
    }
}
