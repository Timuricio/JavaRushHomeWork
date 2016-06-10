package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;


/**
 * Created by Timur on 16.05.2016.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int money;
        while (true)
        {
            ConsoleHelper.writeMessage("before");
            try
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                money = Integer.parseInt(ConsoleHelper.readString());

                if (money<=0)
                    throw new NumberFormatException();

                if (!manipulator.isAmountAvailable(money))
                    throw new NotEnoughMoneyException();

                manipulator.withdrawAmount(money);

                ConsoleHelper.writeMessage(res.getString("money.out"));
                break;
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }
    }
}
