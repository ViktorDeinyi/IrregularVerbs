

import java.time.LocalTime;
import java.util.*;

public class Run {
    public static final String UKR = "(Ukrainian)";
    public static final String V1 = "(V1 Infinitive)";
    public static final String V2 = "(V2 Past Simple)";
    public static final String V3 = "(V3 Participle)";
    public static String answer1;
    public static String answer2;
    public static String answer3;
    public static String question;

    public static Map<Integer, String> names = Map.of(
            0, "(V1 Infinitive)",
            1, "(V2 Past Simple)",
            2, "(V3 Participle)",
            3, "(Ukrainian)");

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";


    int[] checkOriginal;
    public static boolean checkNewTest = true;
    public static void lessonRun(String[][] activeMassive) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of verbs you would like to learn ");
        System.out.println("[1-10 (1)]\t\t[11-20 (2)]\t\t[21-30 (3)]\t\t[31-40 (4)]\t\t[41-50 (5)]\t\t\t\t[RETURN (0)]");
        byte amountOfVerbs = 0;
        try {
            amountOfVerbs = sc.nextByte();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println("Хм, похоже ввели некорректный формат цифр ... \nДавай попробуем ввести правильно:");
            sc.nextLine();
            lessonRun(activeMassive);
        }
        if (amountOfVerbs == 1) {
            for (int i = 1; i < 11; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 2) {
            for (int i = 11; i < 21; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 3) {
            for (int i = 21; i < 31; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 4) {
            for (int i = 31; i < 41; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 5) {
            for (int i = 41; i < 51; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 0) {
            Menus.learningType();
        } else {
            System.out.println("Looks like we don't have enough cases for this lesson. Please choose another.");
            lessonRun(activeMassive);
        }
        System.out.println(amountOfVerbs);

        System.out.println("\n" + "What you would like to do next :  ");
        System.out.println("\t[Learn another verbs (1)]\t\t[Take a quiz with learned words (2)]\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            lessonRun(activeMassive);
        } else if (nextStep.equals("2")) {
            //переход на exam по выученным словам
            examRunL(3, 0, 1, 2, activeMassive, amountOfVerbs);
        } else if (nextStep.equals("0")) {
            Menus.learningType();
        } else if (nextStep.equals("e") || nextStep.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

