package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return Objects.equals(first, n.first) && Objects.equals(last, n.last);

    }
    public int hashCode()
    {
        int f = 0, l = 0;
        f = first == null ? 0 : first.hashCode();
        l = last == null ? 0 : last.hashCode();
        return 31 * f + l;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
