package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution solution1 = new Solution();
        Solution solution2 = new Solution();

        Solution.InnerClass inner1 =  solution1.new InnerClass();
        Solution.InnerClass inner2 =  solution1.new InnerClass();
        solution1.innerClasses[0]= inner1;
        solution1.innerClasses[1]= inner2;

        Solution.InnerClass inner3 =  solution2.new InnerClass();
        Solution.InnerClass inner4 =  solution2.new InnerClass();
        solution2.innerClasses[0]= inner3;
        solution2.innerClasses[1]= inner4;

        Solution[] solutions = new Solution[]{solution1,solution2};

        return solutions;
    }
}
