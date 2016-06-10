package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader filereader = new FileReader(reader.readLine());

        reader.close();
        int count = 0;
        String s = "";

        while (filereader.ready())
        {
            int n = filereader.read();
            if (n > 64 && n < 91 || n > 96 && n < 123)
                s += (char) n;
            else
            {
                if (s.equals("world"))
                    count++;
                s="";
            }
        }


        filereader.close();
        System.out.print(count);
    }
}
