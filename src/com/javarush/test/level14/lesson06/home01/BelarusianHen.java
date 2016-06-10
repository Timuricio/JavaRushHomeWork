package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Timur on 24.03.2016.
 */
public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth() {
        return 12;
    }

    String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" в месяц.";
    }

}
