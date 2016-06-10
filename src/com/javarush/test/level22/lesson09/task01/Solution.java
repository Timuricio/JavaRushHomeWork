package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader pathFile = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(pathFile.readLine()));
        ArrayList<String> list = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        pathFile.close();

        while (reader.ready())
        {
            String s = reader.readLine();
            String[] sArray = s.split(" ");
            Collections.addAll(list, sArray);
        }

        reader.close();

        for (int i = 0; i < list.size()-1; i++)
        {
            stringBuilder.append(list.get(i));

            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(j).equals(stringBuilder.reverse().toString()))
                {
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(j);
                    result.add(pair);
                    list.remove(list.get(j));
                }

            }
            stringBuilder = new StringBuilder();
        }

    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
