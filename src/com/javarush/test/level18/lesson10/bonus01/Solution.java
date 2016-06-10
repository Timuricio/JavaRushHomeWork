package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String key = args[0], fileName = args[1], fileOutputName= args[2];
        boolean coded = true;
        if (key.equals("-d"))
            coded = false;

        FileReader input = new FileReader(fileName);
        FileWriter output = new FileWriter(fileOutputName);

        while (input.ready())
        {
            int i = input.read();
            if (coded)
                output.write(i-1);
            else
                output.write(i+1);
        }
        input.close();
        output.close();
    }

}
