package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location your_file_name
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу "your_file_name", null
        try
        {
            File your_file_name = File.createTempFile("javaRush",".txt",new File("D:/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User timur = new User();
            User maxim = new User();
            maxim.setFirstName("Maxim");
            maxim.setLastName("Kabanov");
            maxim.setMale(true);
            maxim.setCountry(User.Country.RUSSIA);
            maxim.setBirthDate(new Date(89,05,18));

            javaRush.users.add(timur);
            javaRush.users.add(maxim);
            javaRush.users.add(timur);
            javaRush.users.add(maxim);

            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            for (int i = 0; i < users.size(); i++)
            {
                User user = users.get(i);

                if (user.getFirstName() == null || user.getFirstName().isEmpty())
                    printWriter.println(0);
                else
                {
                    printWriter.println(1);
                    printWriter.println(user.getFirstName());
                }

                if (user.getLastName() == null || user.getLastName().isEmpty())
                    printWriter.println(0);
                else
                {
                    printWriter.println(1);
                    printWriter.println(user.getLastName());
                }

                if (user.isMale())
                    printWriter.println("male");
                else
                    printWriter.println("female");

                if (user.getBirthDate() == null)
                    printWriter.println(0);
                else
                {
                    printWriter.println(1);
                    printWriter.println(format.format(user.getBirthDate()));
                }

                if (user.getCountry() == null)
                    printWriter.println(0);
                else
                {
                    printWriter.println(1);
                    printWriter.println(user.getCountry().getDisplayedName());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int userQuantity = Integer.parseInt(reader.readLine());
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            for (int i = 0; i < userQuantity; i++)
            {
                User user = new User();
                if (reader.readLine().equals("1"))
                    user.setFirstName(reader.readLine());
                if (reader.readLine().equals("1"))
                    user.setLastName(reader.readLine());

                if (reader.readLine().equals("male"))
                    user.setMale(true);
                else
                    user.setMale(false);

                if (reader.readLine().equals("1"))
                    user.setBirthDate(format.parse(reader.readLine()));
                if (reader.readLine().equals("1"))
                    user.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
                users.add(user);
            }
            reader.close();
        }
    }
}
