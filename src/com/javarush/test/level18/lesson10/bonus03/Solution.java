package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import com.javarush.test.level15.lesson12.home03.Tree;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        TreeMap<String, String> map = new TreeMap<>();

        final int idNumber = 8;
        final int productNameNumber = 30;
        final int priceNumber = 8;
        final int quantityNumber = 4;

        String parametrCrUD = args[0];
        String currentId = args[1];

        if (currentId.length() < idNumber)
            currentId = String.format("%-8s", currentId);

        BufferedReader fileRearer = new BufferedReader(new FileReader(fileName));
        String s = "";
        String id = "";
        while (fileRearer.ready())
        {
            s = fileRearer.readLine();
            id = s.substring(0, idNumber);
            s = s.substring(8);
            map.put(id, s);
        }
        fileRearer.close();


        if (parametrCrUD.equals("-d") && map.containsKey(currentId))
        {
            map.remove(currentId);
            rewriteFile(fileName, map);
        }

        if (parametrCrUD.equals("-u") && map.containsKey(currentId))
        {
            String productName = args[2];
            String price = args[3];
            String quantity = args[4];

            if (productName.length() > productNameNumber)
                productName = productName.substring(0, productNameNumber);
            else if (productName.length() < productNameNumber)
                productName = String.format("%-30s", productName);

            if (price.length() > priceNumber)
                price = price.substring(0, priceNumber);
            else if (price.length() < priceNumber)
                price = String.format("%-8s", price);

            if (quantity.length() > quantityNumber)
                quantity = quantity.substring(0, quantityNumber);
            else if (quantity.length() < quantityNumber)
                quantity = String.format("%-4s", quantity);

            String item = productName + price + quantity;
            map.put(currentId, item);
            rewriteFile(fileName, map);
        }


    }

    private static void rewriteFile(String fileName, TreeMap<String, String> map) throws IOException
    {
        FileWriter fileWriter = new FileWriter(fileName);
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            fileWriter.write(pair.getKey() + pair.getValue() + "\n");
        }

        fileWriter.close();
    }
}
