package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Timur on 10.05.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите номер порта.");
        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort))
        {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true)
            {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (Exception e)
        {
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Connection connection : connectionMap.values())
        {
            try
            {
                connection.send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Сообщение не отправлено. Очень жаль.");
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            String userName = "";
            try (Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }
            catch (IOException e1)
            {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }

            if (!userName.isEmpty())
            {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");


        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                String userName = message.getData();
                if (message.getType().equals(MessageType.USER_NAME) && !userName.isEmpty() && userName != null && !connectionMap.containsKey(userName))
                {
                    connectionMap.put(message.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return userName;
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (String user : connectionMap.keySet())
            {
                if (!user.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, user));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType().equals(MessageType.TEXT))
                {
                    String messageStr = String.format("%s: %s", userName, message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageStr));
                } else
                    ConsoleHelper.writeMessage("Ошибка сообщения.");

            }
        }
    }
}
