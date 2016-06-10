package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Gilmor","Stan");
        map.put("Ftrim","Anton");
        map.put("Petrov","Stan");
        map.put("Ivanov","Liza");
        map.put("Gunov","Stan");
        map.put("Gnuty","Kael");
        map.put("Zozo","Givi");
        map.put("Silverstain","Liza");
        map.put("Unut","Gomic");
        map.put("Galimov","Timur");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        for (int i=0;i<map.size();i++)
        {
            ArrayList<String> list = new ArrayList<String>(map.values());
            for (int j=i+1;j<list.size();j++)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    removeItemFromMapByValue(map,list.get(i));
                    i--;
                    break;
                }

            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
