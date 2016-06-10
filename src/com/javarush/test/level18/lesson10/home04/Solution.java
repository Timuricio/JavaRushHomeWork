package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream input1 = new FileInputStream(file1);
        FileInputStream input2 = new FileInputStream(file2);
        byte[] content1 = new byte[input1.available()];
        input1.read(content1);
        input1.close();
        FileOutputStream output1 = new FileOutputStream(file1);
        while (input2.available()>0)
        {
            int temp = input2.read();
            output1.write(temp);
        }
        input2.close();
        output1.write(content1);
        output1.close();

    }
}
