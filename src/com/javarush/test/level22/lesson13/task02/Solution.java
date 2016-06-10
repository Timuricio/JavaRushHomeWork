package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]);

        Charset Win1251 = Charset.forName("Windows-1251");
        Charset UTF = Charset.forName("UTF-8");

        byte[] buffer = new byte[in.available()];

        in.read(buffer);

        String s = new String(buffer, UTF);
        buffer = s.getBytes(Win1251);
        out.write(buffer);
        in.close();
        out.close();

    }
}
