
import java.io.*;
import java.util.Scanner;

public class Files {
    public static String userNameOriginal = "NoStatistics";

    public static void newFFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of new user");
        String name = sc.next();
        userNameOriginal = name;
        sc.nextLine();
        try {
            File newOne = new File(name);
            if (newOne.createNewFile()) {
                System.out.println("New user " + newOne.getName() + " was created.");
            } else {
                Menus.anotherNew();
            }
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String userName, String w) {
        try {
            FileWriter user = new FileWriter(userName, true);
            user.write(w);
            user.close();
            System.out.println(userNameOriginal + " statistics was successfully saved.");
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }

    public static void readFile(String us) {
        try {
            File readFile = new File(us);
            Scanner read = new Scanner(readFile);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading");
            e.printStackTrace();
        }
    }

    public static boolean userIsExist(String us) {
        File f = new File(us);
        return f.exists();
    }
}

