package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {

        private Person person;
        private Scanner scanner;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        private Date date;
        private String dateBirth;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] s = scanner.nextLine().split(" ");
            dateBirth = s[3] + " " + s[4] + " " + s[5];

            try
            {
                date = dateFormat.parse(dateBirth);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            person = new Person(s[1],s[2],s[0], date);
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
