package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        ArrayList<Throwable> list = new ArrayList<>();
        t.interrupt();
        list.add(e);
        while (e.getCause() != null)
        {
            e = e.getCause();
            list.add(e);
        }

        for (int i =list.size()-1;i>=0;i--)
        {
            Throwable e1 = list.get(i);
            System.out.println(e1.getClass().getName()+": "+e1.getMessage());
        }
    }
}
