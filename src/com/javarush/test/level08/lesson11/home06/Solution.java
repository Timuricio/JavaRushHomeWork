package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> vnuki = new ArrayList<Human>();
        ArrayList<Human> deti1 = new ArrayList<Human>();
        ArrayList<Human> deti2 = new ArrayList<Human>();
        ArrayList<Human> no = new ArrayList<Human>();

        Human vnuk1 = new Human("Vnuk1", true,7,no);
        Human vnuk2 = new Human("Vnuk2", false,8,no);
        Human vnuk3 = new Human("Vnuk3", true,3,no);
        vnuki.add(vnuk1);
        vnuki.add(vnuk2);
        vnuki.add(vnuk3);
        Human papa = new Human("Papa", true,35,vnuki);
        Human mama = new Human ("Mama", false, 34,vnuki);
        deti1.add(papa);
        deti2.add(mama);
        Human ded1 = new Human("Ded1",true,99,deti1);
        Human ded2 = new Human("Ded2", true, 98, deti2);
        Human bab1 = new Human("Baba1,", false, 97, deti1);
        Human bab2 = new Human("Baba2,", false, 96, deti2);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());
        System.out.println(papa.toString());
        System.out.println(mama.toString());
        System.out.println(vnuk1.toString());
        System.out.println(vnuk2.toString());
        System.out.println(vnuk3.toString());

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
