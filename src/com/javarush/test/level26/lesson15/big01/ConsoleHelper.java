package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Timur on 27.04.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {

        String message = "";
        try
        {
            message = reader.readLine();
        }
        catch (Exception e)
        {
        }
        if (message.equalsIgnoreCase(res.getString("EXIT")))
            throw new InterruptOperationException();
        return message;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation;
        int numberOfOperation = 0;
        while (true)
        {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - "+res.getString("operation.INFO"));
            writeMessage("2 - "+res.getString("operation.DEPOSIT"));
            writeMessage("3 - "+res.getString("operation.WITHDRAW"));
            writeMessage("4 - "+res.getString("operation.EXIT"));

            try
            {
                numberOfOperation = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(numberOfOperation);
                break;
            }
            catch (NumberFormatException ignore)
            {
                writeMessage(res.getString("invalid.data"));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }

        return operation;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String code = readString();

        while (code.length() != 3)
        {
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            code = readString();
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        boolean correct = false;
        String[] s = new String[2];
        while (!correct)
        {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            int denomination = 0, count = 0;
            String[] temp = readString().split(" ");
            try
            {
                if (temp.length != 2)
                    throw new Exception();
                denomination = Integer.parseInt(temp[0]);
                count = Integer.parseInt(temp[1]);

            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
            }

            if (denomination > 0 && count > 0)
            {
                s = temp;
                correct = true;
            }

        }
        return s;
    }

}
