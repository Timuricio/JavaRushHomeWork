package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Gilmor","Stan");
        map.put("Ftrim","Anton");
        map.put("Petrov","Stan");
        map.put("Ivanov","Frank");
        map.put("Gunov","Stan");
        map.put("Gnuty","Kael");
        map.put("Zozo","Givi");
        map.put("Silverstain","Liza");
        map.put("Unut","Gomic");
        map.put("Galimov","Timur");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i =0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            if (pair.getValue().equals(name))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int i =0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            if (pair.getKey().equals(lastName))
                i++;
        }
        return i;

    }
}
