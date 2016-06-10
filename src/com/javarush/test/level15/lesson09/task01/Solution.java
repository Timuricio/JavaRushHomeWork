package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(12D,"nbv");
        labels.put(13D,"nbv2");
        labels.put(14D,"n32v");
        labels.put(15D,"rrer");
        labels.put(17D,"23434");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
