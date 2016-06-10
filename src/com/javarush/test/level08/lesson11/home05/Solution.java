package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Character.toUpperCase;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        char[] sChar = s.toCharArray();

        for (int i =1;i<sChar.length;i++) {
            if (sChar[i-1] == ' '&& sChar[i] !=' ')
                sChar[i] = Character.toUpperCase(sChar[i]);

        }
        String s2 = new String(sChar);
        System.out.print(s2);
    }


}
