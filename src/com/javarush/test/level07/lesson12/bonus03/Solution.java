package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        array = sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static int[] sort(int[] array)
    {
        boolean t = true;
        int j=0;
        while (t) {
            for (int i=0;i<array.length-1;i++) {
                if (array[i]<array[i+1]){
                    int k = array[i];
                    array[i]= array[i+1];
                    array[i+1] = k;
                    j++;
                }
            }

            if(j>0) {
                j=0;
            }
            else
                t = false;
        }
        return array;
    }
}
