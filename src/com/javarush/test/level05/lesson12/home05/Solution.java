package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        boolean q = true;
        int iA=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (q) {
            String sA = reader.readLine();
            if (!sA.equals("сумма"))
                iA += Integer.parseInt(sA);
            else
                q = false;

        }
        System.out.print(iA);
    }
}
