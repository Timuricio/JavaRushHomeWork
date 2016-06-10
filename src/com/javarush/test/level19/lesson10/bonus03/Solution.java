package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> stringList = new ArrayList<>();
        while (file.ready())
        {
            stringBuilder = stringBuilder.append(file.readLine());
        }
        String inTag = args[0];
        String stringBuild = stringBuilder.toString().replaceAll("\r\n", "");
        ArrayList<Pair> list = new ArrayList<>();
        String opening = "<".concat(inTag);
        String closing = "</".concat(inTag);
        int length = inTag.length();
        int indexOne = 0;

        while ((indexOne != -1) && (indexOne < stringBuild.length()))
        {
            indexOne = stringBuild.indexOf(opening, indexOne);
            int indexTwo = stringBuild.indexOf(closing, indexOne + length);
            int k = indexOne + length;
            if (indexTwo != -1)
            {
                while (stringBuild.substring(k, indexTwo).contains(opening))
                {
                    k = indexTwo + length;
                    indexTwo = stringBuild.indexOf(closing, k);
                }
            }
            if (indexOne != -1 && indexTwo != -1)
            {
                list.add(new Pair(indexOne, indexTwo));
                indexOne += length;
            }
        }

        for (Pair pair : list)
        {
            String str = stringBuild.substring(pair.getA(), pair.getB() + length + 3);
            stringList.add(str);
        }


        for (String s1 : stringList)
        {
            System.out.println(s1);
        }
    }

    public static class Pair
    {
        private int a;
        private int b;

        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        public int getA()
        {
            return a;
        }

        public int getB()
        {
            return b;
        }
    }
}
