package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a==1)
            System.out.print("понедельник");
        else if (a==2)
            System.out.print("вторник");
        else if (a==3)
            System.out.print("среда");
        else if (a==4)
            System.out.print("четверг");
        else if (a==5)
            System.out.print("пятница");
        else if (a==6)
            System.out.print("суббота");
        else if (a==7)
            System.out.print("воскресенье");
        else
            System.out.print("такого дня недели не существует");

    }

}