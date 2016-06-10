package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human h1 = new Human("Timur",true);
        Human h2 = new Human("Timur","Russ");
        Human h3 = new Human (12,13);
        Human h4 = new Human (true,12,"Timur","Russ",12,15);
        Human h5 = new Human("Rus","Timur",12);
        Human h6 = new Human (11,32,"Russ");
        Human h7 = new Human (32,12,"Russ","Timur");
        Human h8 = new Human (true,12,"Timur","Russ",12);
        Human h9 = new Human(true,12);
        Human h10 = new Human(true);

    }

    public static class Human
    {
        private boolean sex;
        private int age;
        private String name;
        private String nation;
        private int weigth;
        private int toll;

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String nation)
        {
            this.name = name;
            this.nation = nation;
        }

        public Human(int toll, int weigth)
        {
            this.toll = toll;
            this.weigth = weigth;
        }

        public Human(boolean sex, int age, String name, String nation, int toll, int weigth)
        {
            this.sex = sex;
            this.age = age;
            this.name = name;
            this.nation = nation;
            this.toll = toll;
            this.weigth = weigth;
        }

        public Human(String nation, String name, int age)
        {
            this.nation = nation;
            this.name = name;
            this.age = age;
        }

        public Human(int toll, int weigth, String nation)
        {
            this.toll = toll;
            this.weigth = weigth;
            this.nation = nation;
        }

        public Human(int toll, int weigth, String nation, String name)
        {
            this.toll = toll;
            this.weigth = weigth;
            this.nation = nation;
            this.name = name;
        }

        public Human(boolean sex, int age, String name, String nation, int weigth)
        {
            this.sex = sex;
            this.age = age;
            this.name = name;
            this.nation = nation;
            this.weigth = weigth;
        }

        public Human(boolean sex, int toll)
        {
            this.sex = sex;
            this.toll = toll;
        }

        public Human(boolean sex)
        {
            this.sex = sex;
        }
    }
}
