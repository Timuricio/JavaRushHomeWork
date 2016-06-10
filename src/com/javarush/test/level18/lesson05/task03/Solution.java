package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.nio.file.FileSystemException;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream input = new FileInputStream(file1);
        FileOutputStream output2 = new FileOutputStream(file2);
        FileOutputStream output3 = new FileOutputStream(file3);
        int size = input.available()/2;
        while(input.available()>size)
        {
            int r = input.read();
            output2.write(r);
        }

        while (input.available()>0)
        {
            int r = input.read();
            output3.write(r);
        }
        input.close();
        output2.close();
        output3.close();

    }
}
