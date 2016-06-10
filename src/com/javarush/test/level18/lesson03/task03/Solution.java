package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        reader.close();
        while (input.available()>0) {
            int n = input.read();
            if (map.containsKey(n))
                incr(map,n);
            else
                map.put(n,1);
        }
        input.close();
        System.out.println(sort(map));

    }

    public static void incr (HashMap<Integer,Integer> map, int b)
    {
        int temp;
        for (Map.Entry<Integer,Integer> pair : map.entrySet())
        {
            if (pair.getKey() == b) {
                temp = pair.getValue()+1;
                pair.setValue(temp);
            }

        }
    }

    public static String sort (HashMap<Integer,Integer> map)
    {
        String s ="";
        int value=0;

        for (Map.Entry<Integer,Integer> pair : map.entrySet())
        {
            if (pair.getValue()>value)
                value=pair.getValue();
        }
        for (Map.Entry<Integer,Integer> pair : map.entrySet())
        {
            if (pair.getValue()==value)
                s += pair.getKey()+ " ";
        }

        return s;
    }
}
