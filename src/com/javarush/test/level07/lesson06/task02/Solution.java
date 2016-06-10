package com.javarush.test.level07.lesson06.task02;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int l=0;
        for(int i =0;i<5;i++) {
            list.add(reader.readLine());
        }
        for(int i =0;i<5;i++) {
            if (l<list.get(i).length())
                l=list.get(i).length();
        }
        for(int i =0;i<5;i++) {
            if (list.get(i).length()==l)
                System.out.println(list.get(i));
        }



    }
}
