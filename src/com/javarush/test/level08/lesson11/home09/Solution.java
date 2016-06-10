package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static boolean isDateOdd(String date)
    {
        Date date1 = new Date(date);
        Date date2 = new Date(0,0,1,0,0,0);
        long c = 1000*3600*24;

        date2.setYear(date1.getYear());
        long l = date1.getTime()-date2.getTime()+c;
        int res = (int)(l/c);

        if (res==1)
            return true;
        else if (res%2==0)
            return false;
        else
            return true;
    }
}
