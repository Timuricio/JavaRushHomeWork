package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> map = new TreeMap<String, Integer>();
        String fileName = "";
        String finalFileName = "";
        while (true)
        {
            fileName = reader.readLine();
            if (fileName.equals("end"))
                break;
            String[] fileNameArray = fileName.split("\\.");
            finalFileName = fileNameArray[0] + "." + fileNameArray[1];
            map.put(fileName,0);
        }

        reader.close();

        FileWriter output = new FileWriter(finalFileName);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            FileReader input = new FileReader(pair.getKey());
            while (input.ready())
            {
                int i = input.read();
                output.write(i);
            }
            input.close();
        }

        output.close();


    }
}
