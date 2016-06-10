package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact
    {
        private IncomeData income;

        public IncomeDataAdapter(IncomeData income)
        {
            this.income = income;
        }

        @Override
        public String getName()
        {
            return this.income.getContactLastName()+", "+this.income.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder s = new StringBuilder(String.valueOf(this.income.getPhoneNumber()));
            while(s.length() < 10)
                s.insert(0,"0");
            return String.format("+%s(%s)%s-%s-%s", this.income.getCountryPhoneCode(), s.substring(0, 3),
                    s.substring(3, 6), s.substring(6, 8), s.substring(8));
        }

        @Override
        public String getCompanyName()
        {
            return this.income.getCompany();
        }

        @Override
        public String getCountryName()
        {
            String s=null;
            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (pair.getKey().equals(this.income.getCountryCode()))
                    s =  pair.getValue();
            }
            return s;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}