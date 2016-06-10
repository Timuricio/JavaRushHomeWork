package com.javarush.test.level30.lesson15.big01.client;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Timur on 11.05.2016.
 */
public class BotClient extends Client
{
    private static int botCounter = 0;

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }


    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            if (message.contains(":") && !message.contains("Привет чатику."))
            {
                String userName = message.substring(0, message.indexOf(":"));
                String command = message.substring(message.indexOf(": ") + 2);
                String text = String.format("Информация для %s: ", userName);
                switch (command)
                {
                    case "дата":
                        text = text.concat(new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "день":
                        text = text.concat(new SimpleDateFormat("d").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "месяц":
                        text = text.concat(new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "год":
                        text = text.concat(new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "время":
                        text = text.concat(new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "час":
                        text = text.concat(new SimpleDateFormat("H").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "минуты":
                        text = text.concat(new SimpleDateFormat("m").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                    case "секунды":
                        text = text.concat(new SimpleDateFormat("s").format(Calendar.getInstance().getTime()));
                        sendTextMessage(text);
                        break;
                }
            }
        }
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        if (botCounter == 99)
            botCounter = 0;
        return String.format("date_bot_%d", botCounter++);
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }
}
