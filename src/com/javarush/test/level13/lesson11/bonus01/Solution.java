package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream input = new DataInputStream( new FileInputStream(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (input.available()>0)
        {
            list.add(Integer.parseInt(input.readLine()));
        }
        input.close();

        for (int i =0;i<list.size();i++) {

            if (list.get(i)%2!=0 || list.get(i)==1) {
                list.remove(i);
                i--;
            }


        }
        sort(list);
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }




    }

    static void sort (ArrayList<Integer> list)
    {
    while (true)
    {   int m = 0;
        for (int i = 1; i < list.size(); i++)
        {

            if (list.get(i - 1) > list.get(i))
            {
                int temp = list.get(i - 1);
                list.set(i - 1, list.get(i));
                list.set(i, temp);
                m++;
            }

        }
        if (m == 0)
        break;
    }
    }
}
