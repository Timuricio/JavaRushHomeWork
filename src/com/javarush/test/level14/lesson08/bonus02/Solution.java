package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int iFirst = Integer.parseInt(reader.readLine());
        int iSecond = Integer.parseInt(reader.readLine());

        while (iFirst!=0 && iSecond!=0) {
            if (iFirst>iSecond)
                iFirst = iFirst % iSecond;
            else
                iSecond = iSecond%iFirst;
        }
        System.out.print(iFirst+iSecond);
    }
}
