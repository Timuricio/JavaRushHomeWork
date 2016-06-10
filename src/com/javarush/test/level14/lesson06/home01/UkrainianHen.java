package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Timur on 24.03.2016.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth() {
        return 45;
    }

    String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" в месяц.";
    }
}
