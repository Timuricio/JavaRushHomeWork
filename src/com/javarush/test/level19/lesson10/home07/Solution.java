package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        FileWriter output = new FileWriter(args[1]);
        String s = "";
        while (input.ready())
        {
            String temp[] = input.readLine().split(" ");
            for (String i : temp)
            {
                if (i.length() > 6)
                    s += "," + i;
            }

        }
        s = s.substring(1);
        output.write(s);
        input.close();
        output.close();
    }
}
