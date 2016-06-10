package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());
        int a5 = Integer.parseInt(reader.readLine());

        int [] arr = new int[5];
        arr[Comp(a1,a2,a3,a4,a5)] = a1;
        arr[Comp(a2,a1,a3,a4,a5)] = a2;
        arr[Comp(a3,a2,a1,a4,a5)] = a3;
        arr[Comp(a4,a2,a3,a1,a5)] = a4;
        arr[Comp(a5,a2,a3,a4,a1)] = a5;

        for (int i =0;i<5;i++)
            System.out.println(arr[i]);

    }

    public static int Comp (int a, int b, int c, int d, int e) {
        int i =0;

        if (a>b)
            i++;
        if (a>c)
            i++;
        if (a>d)
            i++;
        if (a>e)
            i++;
        return i;
    }


}
