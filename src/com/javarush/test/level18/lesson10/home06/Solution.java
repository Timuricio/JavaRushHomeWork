package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream input = new FileInputStream(args[0]);

        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        while (input.available()>0)
        {
            int b = input.read();
            if (map.containsKey(b))
                incr(map, b);
            else
                map.put(b,1);
        }

        input.close();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char)key + " " + value);
        }


    }

    public static void incr(TreeMap<Integer, Integer> map, int b)
    {
        for (Map.Entry<Integer,Integer> pair : map.entrySet())
        {
            if (pair.getKey()==b)
                pair.setValue(pair.getValue()+1);
        }
    }

}
