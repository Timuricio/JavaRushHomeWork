package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
    {
        List<String> listFile = new ArrayList<>();
        List<File> listDir = new ArrayList<>();

        File rootDir = new File (root);
        listDir.add(rootDir);

        for (int i =0; i<listDir.size();i++)
        {
            File directory = listDir.get(i);

            if (directory.listFiles().length>0)
            {
                for (File file : directory.listFiles())
                {
                    if (file.isDirectory())
                        listDir.add(file);
                    else
                        listFile.add(file.getAbsolutePath());
                }
            }
        }

        return listFile;

    }
}
