package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Timur on 17.05.2016.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");


    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String userCardNumber = ConsoleHelper.readString();
            String userPin = ConsoleHelper.readString();
            if (userCardNumber ==null ||userPin==null|| userCardNumber.length() != 12 || userPin.length() != 4)
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userCardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (!validCreditCards.containsKey(userCardNumber) || !userPin.equals(validCreditCards.getString(userCardNumber)))
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),userCardNumber));
                break;
            }

        }

    }
}
