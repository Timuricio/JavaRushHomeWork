package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileOutputStream output1 = new FileOutputStream(file1);
        FileInputStream input2 = new FileInputStream(file2);
        FileInputStream input3 = new FileInputStream(file3);

        while (input2.available()>0)
        {
            int buf = input2.read();
            output1.write(buf);
        }

        while (input3.available()>0)
        {
            int buf = input3.read();
            output1.write(buf);
        }
        input2.close();
        input3.close();
        output1.close();

    }
}
