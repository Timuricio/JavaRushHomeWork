package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = s.substring(s.indexOf('?')+1);
        s="";
        String sDoub="",sStr="";
        String[] s3 = s2.split("&");
        for (int i=0;i<s3.length;i++)
        {
            if (s3[i].contains("=")) {
                String[] s4 = s3[i].split("=");
                if (s4[0].equals("obj"))
                {
                    s+=s4[0]+ " ";
                    try
                    {
                        Double.parseDouble(s4[1]);
                        sDoub = s4[1];
                    }
                    catch (NumberFormatException e)
                    {
                        sStr = s4[1];
                    }
                }
                else
                {
                    s+=s4[0]+" ";
                }
            }
            else
                s+=s3[i]+" ";
        }
        System.out.println(s);
        if (!sStr.isEmpty())
            alert(sStr);
        if (!sDoub.isEmpty())
            alert(Double.parseDouble(sDoub));
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
