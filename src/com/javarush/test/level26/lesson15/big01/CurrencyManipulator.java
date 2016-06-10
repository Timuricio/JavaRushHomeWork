package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Timur on 28.04.2016.
 */
public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination)+count);
        else
            denominations.put(denomination,count);

    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            result+=pair.getKey()*pair.getValue();
        }
        return result;
    }
    public boolean hasMoney()
    {
        if (this.getTotalAmount()!=0)
            return true;
        else
            return false;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        if (expectedAmount>this.getTotalAmount())
            return false;
        else
            return true;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });
        ArrayList<Integer> listDenomin = new ArrayList<>();

        for (Integer i : denominations.keySet())
        {
            listDenomin.add(i);
        }

        Collections.sort(listDenomin);
        Collections.reverse(listDenomin);

        int expected = expectedAmount;
        boolean possibleWithdraw = false;
        while (listDenomin.size()>0)
        {
            for (Integer denomin : listDenomin)
            {
                int countCoupure = expected/denomin;
                if (countCoupure ==0)
                    continue;
                if (countCoupure > denominations.get(denomin))
                {
                    expected -= countCoupure * denominations.get(denomin);
                    result.put(denomin,denominations.get(denomin));
                }
                else
                {
                    expected-=countCoupure*denomin;
                    result.put(denomin,countCoupure);
                }
                if (expected==0)
                    possibleWithdraw = true;
            }

            if (possibleWithdraw)
                break;

            result.clear();

            listDenomin.remove(0);
        }

        if (!possibleWithdraw)
            throw new NotEnoughMoneyException();
        else
        {
            for (Integer i : result.keySet())
            {
                if (result.get(i)==denominations.get(i))
                    denominations.remove(i);
                else
                    denominations.put(i,denominations.get(i)-result.get(i));
            }

            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage(String.format("\t%s - %s",pair.getKey(),pair.getValue()));
            return result;
        }

    }


}
