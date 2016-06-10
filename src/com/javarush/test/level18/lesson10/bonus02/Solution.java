package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        final int idNumber = 8;
        final int productNameNumber = 30;
        final int priceNumber = 8;
        final int quantityNumber = 4;
        int idMax = 0;

        String parametrCrUD = args[0];
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

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

        BufferedReader fileRearer = new BufferedReader(new FileReader(fileName));

        String s = "";

        while (fileRearer.ready())
        {
            s = fileRearer.readLine();
            s = s.substring(0, idNumber);
            s = s.trim();
            if (idMax < Integer.parseInt(s))
                idMax = Integer.parseInt(s);

        }


        fileRearer.close();


        if (parametrCrUD.equals("-c"))
        {
            FileWriter fileWriter = new FileWriter(fileName, true);
            String id = String.valueOf(idMax + 1);
            id = String.format("%-8s", id);
            String item = (id + productName + price + quantity + "\n");
            fileWriter.write(item);
            fileWriter.close();
        }
    }
}
