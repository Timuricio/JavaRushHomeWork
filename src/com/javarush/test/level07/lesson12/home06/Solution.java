package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так,
чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human h1 = new Human ("Ded1",98,true,null,null);
        Human h2 = new Human ("Ded2",97,true,null,null);
        Human h3 = new Human ("Bab1",98,false,null,null);
        Human h4 = new Human ("Bab2",97,false,null,null);
        Human h5 = new Human ("Otec",50,true,h1,h3);
        Human h6 = new Human ("Mat",51,false,h2,h4);
        Human h7 = new Human ("Doch1",25,false,h5,h6);
        Human h8 = new Human ("Sin1",20,true,h5,h6);
        Human h9 = new Human ("Sin2",10,true,h5,h6);

        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(h5.toString());
        System.out.println(h6.toString());
        System.out.println(h7.toString());
        System.out.println(h8.toString());
        System.out.println(h9.toString());


    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        Human father, mother;


        public Human(String name, int age, boolean sex, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
