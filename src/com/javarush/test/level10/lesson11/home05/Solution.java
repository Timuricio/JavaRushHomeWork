package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        //Map.Entry<String,Integer> pair = iterator.next();
        for (int i=0; i<abcArray.length;i++)
        {
            map.put(abcArray[i],0);
        }
        for (String sIter : list)
        {
            char[] chArray = sIter.toCharArray();

            for ( Map.Entry<Character,Integer> pair : map.entrySet())
            {
                for (int i=0;i<chArray.length;i++)
                {
                    if (pair.getKey() == chArray[i])
                        pair.setValue(pair.getValue()+1);

                }
            }

        }

        for (int i =0; i<abcArray.length;i++)
        {
            for ( Map.Entry<Character,Integer> pair : map.entrySet())
            {
                if (pair.getKey() == abcArray[i])
                    System.out.println(pair.getKey()+" "+pair.getValue());
            }

        }

    }

}
