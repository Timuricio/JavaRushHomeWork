package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String adress = reader.readLine();
        OutputStream outFile =new FileOutputStream(adress);
        ArrayList <String> list = new ArrayList<String>();

        while (true) {
            String s = reader.readLine();
            list.add(s);
            if (s.equals("exit"))
                break;

        }

        for (int i =0; i<list.size();i++)
        {
            byte[] buffer = list.get(i).getBytes();
            outFile.write(buffer);

            outFile.write('\r');
        }
        outFile.close();
    }
}
