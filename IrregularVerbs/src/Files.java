
import java.io.*;
import java.util.Scanner;

public class Files {
    public static String userName;
    public static void newFile() throws IOException {
        // create new file (user) [Vlad]
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
        reader.close();
    }
    public static void newFFile () {
        // create new file (user) [Victor]
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.next();
        userName = name;
        sc.nextLine();
        try {
            File newOne = new File(name);
            if (newOne.createNewFile()) {
                System.out.println("Ok " + newOne.getName());
            } else  {
                Menus.anotherNew();
            }
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
    public static void writeToFile (String userName, String w) {
//запись статистики в файл
        try {
            FileWriter user = new FileWriter(userName, true);
            user.write(w);
            user.close();
            System.out.println("Succesfully write.");
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }

    }
    public static void readFile(String us) {
        try {
            File readFile = new File (us);
            Scanner read = new Scanner(readFile);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();}
        catch (FileNotFoundException e) {
            System.out.println("Error reading");
            e.printStackTrace();
        }
    }
    public static boolean userIsExist (String us){
        File f = new File(us);
        return f.exists();
    }
}

