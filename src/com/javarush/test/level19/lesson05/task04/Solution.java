package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader filereader  = new FileReader(reader.readLine());
        FileWriter filewriter = new FileWriter(reader.readLine());
        reader.close();
        while (filereader.ready())
        {
            int i = filereader.read();
            if (i==".".getBytes()[0])
                i="!".getBytes()[0];
            filewriter.write(i);
        }
        filereader.close();
        filewriter.close();
    }
}
