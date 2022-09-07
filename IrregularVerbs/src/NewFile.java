

import java.io.*;
import java.util.Scanner;

public class NewFile {
    public static void newFile() throws IOException {
        // создание нового файла Влада кусок
        System.out.println("Write file name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream(reader.readLine());


        while (true) {
            System.out.println("Write your name:");
            String data = reader.readLine();
            if (data == ("0")) {
                outputStream.write((data + "\r\n").getBytes());
            } else {
                outputStream.write(data.getBytes());
                break;
            }
        }
        outputStream.close();
////        reader.close();
    }

    public static String userName;
    public static void newFFile () {
        // создание нового файла
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name");
        String name = sc.next();
        userName = name;
        sc.nextLine();
        try {
            File newOne = new File(name);
            if (newOne.createNewFile()) {
                System.out.println("Ready " + newOne.getName());
            } else  {
                System.out.println("Already exist ");
            }
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
    public static void writeToFile (String userName, String w) {
//запись статистики в файл
        try {
            FileWriter user = new FileWriter(userName);
            user.write(w);
            user.close();
            System.out.println("Succesfully write.");
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }

    }
}
