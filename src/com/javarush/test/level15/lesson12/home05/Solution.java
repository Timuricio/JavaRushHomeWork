package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(int i)
    {

    }

    private Solution(String s)
    {

    }

    private Solution(boolean b)
    {

    }


    Solution()
    {

    }

    Solution(int i, String s)
    {

    }

    Solution(int i, boolean b)
    {

    }

    protected Solution(boolean b, int i)
    {

    }

    protected Solution(boolean b, String s)
    {

    }

    protected Solution(boolean b, boolean g)
    {

    }

    public Solution(String s, int j)
    {

    }

    public Solution(String s, String f)
    {

    }

    public Solution(String s, boolean b)
    {

    }
}

