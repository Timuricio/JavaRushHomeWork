package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream input = new FileInputStream(args[0]);
        int size = input.available();
        int space = 0;
        while (input.available()>0)
        {
            if (input.read()==" ".getBytes()[0])
                space++;
        }
        input.close();
        double d =space*1.0/size;
        System.out.printf("%.2f",d*100);
    }
}
