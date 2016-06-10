package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        boolean t = true;
        int count=0;
        while (t) {
            for(int i=1;i<array.length;i++) {
                if(isGreaterThan(array[i-1], array[i])) {
                    String s = array[i-1];
                    array[i-1] = array[i];
                    array[i] = s;
                    count++;
                }
            }
            if (count==0)
                t = false;
            count=0;

        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b' array[i-1].charAt(0) > array[i].charAt(0)
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
