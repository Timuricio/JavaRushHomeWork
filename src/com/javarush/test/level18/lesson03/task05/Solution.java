package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        reader.close();
        while (input.available()>0) {
            int n = input.read();
            if (!list.contains(n))
                list.add(n);
        }
        input.close();
        sort(list);
        for (Integer i : list)
            System.out.print(i+" ");
    }

    public static void sort (ArrayList<Integer> list)
    {
        boolean cansel=false;
        int temp=0;
        while (!cansel){
            int count=0;
            for (int i=1;i<list.size();i++) {
                if (list.get(i)<list.get(i-1))
                {
                    temp = list.get(i);
                    list.set(i,list.get(i-1));
                    list.set(i-1,temp);
                    count++;
                }
            }
            if (count==0)
                cansel=true;
        }

    }
}
