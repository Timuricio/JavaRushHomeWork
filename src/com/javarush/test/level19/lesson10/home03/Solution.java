package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String name = "";
        Date date;
        int day = 0, mounth = 0, yer = 0;

        while (reader.ready())
        {
            String temp[] = reader.readLine().split(" ");

            day = Integer.parseInt(temp[temp.length-3]);
            mounth = Integer.parseInt(temp[temp.length-2]);
            yer = Integer.parseInt(temp[temp.length-1]);

            for (int i =0; i<temp.length-3;i++)
                name+=temp[i]+" ";

            name = name.trim();

            date = new Date(yer, mounth-1, day);
            PEOPLE.add(new Person(name, date));

            name = "";
        }

        reader.close();


    }

}
