package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        InputStream input = new FileInputStream(filePath);
        Properties properti = new Properties();

        while(input.available()>0)
        {
            properti.load(input);
        }

        input.close();

        for(Map.Entry<Object,Object> pair : properti.entrySet())
        {
            properties.put((String)pair.getKey(),(String)pair.getValue());
        }


    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String,String> pair : properties.entrySet())
        {
            prop.put(pair.getKey(),pair.getValue());
        }
        prop.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();

        while (inputStream.available()>0)
            prop.load(inputStream);

        for(Map.Entry<Object,Object> pair : prop.entrySet())
        {
            properties.put((String)pair.getKey(),(String)pair.getValue());
        }
    }
}
