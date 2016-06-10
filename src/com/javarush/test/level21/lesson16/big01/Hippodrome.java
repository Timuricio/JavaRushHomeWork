package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Timur on 09.04.2016.
 */
public class Hippodrome
{
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Rush Hour", 3, 0);
        Horse horse2 = new Horse("Lucky Strike", 3, 0);
        Horse horse3 = new Horse("Silver Arrow", 3, 0);

        Collections.addAll(game.getHorses(), horse1, horse2, horse3);

        game.run();
        game.printWinner();
    }

    static ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }

        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner()
    {

        Horse winner = this.getHorses().get(0);

        for (Horse horse : this.getHorses())
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }

        return winner;
    }

    public void printWinner()
    {
        System.out.printf("Winner is %s!" ,this.getWinner().getName());
    }
}
