package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null)
            throw new TooShortStringException();

        String[] sArray = string.split(" ");

        if (sArray.length<5 || sArray[4].isEmpty())
            throw new TooShortStringException();

        String result = String.format("%s %s %s %s",sArray[1],sArray[2],sArray[3],sArray[4]);
        return result;
    }

    public static class TooShortStringException extends Exception
    {
    }
}
