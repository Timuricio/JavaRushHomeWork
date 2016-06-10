package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> listInt = new ArrayList<String>();
        ArrayList<String> listStr = new ArrayList<String>();
        boolean canselInt = false,canselStr = false;
        for (int i=0;i<array.length;i++)
        {
            if (isNumber(array[i]))
                listInt.add(array[i]);
            else
                listStr.add(array[i]);
        }

        while (!canselInt)
        {
            int count=0;
            for (int i =0;i<listInt.size()-1;i++)
            {
                if (Integer.parseInt(listInt.get(i + 1))> Integer.parseInt(listInt.get(i))) {
                    String s = listInt.get(i);
                    listInt.set(i,listInt.get(i+1));
                    listInt.set(i+1,s);
                    count++;;
                }
            }
            if (count==0)
                canselInt=true;
        }

        while (!canselStr)
        {
            int count=0;
            for (int i =0;i<listStr.size()-1;i++)
            {
                if (isGreaterThan(listStr.get(i),listStr.get(i + 1))) {
                    String s = listStr.get(i);
                    listStr.set(i,listStr.get(i+1));
                    listStr.set(i+1,s);
                    count++;
                }
            }
            if (count==0)
                canselStr=true;
        }

        for (int i=0;i<array.length;i++)
        {
            if (isNumber(array[i])){
                array[i]=listInt.get(0);
                listInt.remove(0);
            }
            else {
                array[i]=listStr.get(0);
                listStr.remove(0);
            }

        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
