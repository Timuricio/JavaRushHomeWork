package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Timur on 24.03.2016.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth() {
        return 1;
    }

    String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" в месяц.";
    }
}
