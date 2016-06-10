package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        DataInputStream input = new DataInputStream(new FileInputStream(file1));
        FileOutputStream output = new FileOutputStream(file2);
        String s = input.readLine();
        input.close();
        String[] sArray = s.split(" ");
        for (int i =0; i< sArray.length;i++)
        {
            int n = (int) Math.round(Double.parseDouble(sArray[i]));
            s = n+" ";
            output.write(s.getBytes());
        }
        output.close();

    }
}
