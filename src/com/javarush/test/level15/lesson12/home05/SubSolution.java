package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Timur on 27.03.2016.
 */
public class SubSolution extends Solution
{
    private SubSolution(int i)
    {

    }

    private SubSolution(String s)
    {

    }

    private SubSolution(boolean b)
    {

    }




    SubSolution(int i, int j)
    {

    }

    SubSolution(int i, String s)
    {
        super(i, s);
    }

    SubSolution(int i, boolean b)
    {
        super(i, b);
    }

    protected SubSolution(boolean b, int i)
    {
        super(b, i);
    }

    protected SubSolution(boolean b, String s)
    {
        super(b, s);
    }

    protected SubSolution(boolean b, boolean g)
    {
        super(b, g);
    }

    public SubSolution(String s, int j)
    {
        super(s, j);
    }

    public SubSolution(String s, String f)
    {
        super(s, f);
    }

    public SubSolution(String s, boolean b)
    {
        super(s, b);
    }
}
