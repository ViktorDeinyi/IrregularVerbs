

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

    public static void examRun(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive) {
        if (checkNewTest) {
            Menus.amountOfTests();
        }
        byte amountOfAnswers = 3;
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        for (int w = 0; indexAnswers.length > w; w++) {
            if (indexAnswers[w] < 0) amountOfAnswers--;
        }
        System.out.println(Menus.cases);
        int index = 0;
        double error = 0;
        int[] checkOriginal = new int[Menus.cases];
        ArrayList<Integer> checkMistakes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        LocalTime startTime = LocalTime.now();
        do {
            Menus.cases--;
            int wordNumber = randomNumber(activeMassive.length - 1);
            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(activeMassive.length - 1);
                    System.out.println("замена" + wordNumber);
                    i = -1;
                }
                ++i;
            }
            checkOriginal[index] = wordNumber;
            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
            System.out.print("\n" + index + "/" + checkOriginal.length + "\t");
            for (int x = 1; x <= amountOfAnswers; ++x) {
                System.out.print(names.get(indexAnswers[0]) + "\t" + activeMassive[wordNumber][indexAnswers[0]]);
                System.out.print("  =  " + names.get(indexAnswers[x]) + "  ");
                String name = sc.nextLine();
                name = name.toLowerCase();
                if (activeMassive[wordNumber][indexAnswers[x]].equals(name)) {
                    System.out.println("Correct: " +
                            TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  =  " +
                            TEXT_GREEN + name + TEXT_RESET);
                } else if (name.equals("0")) {
                    System.out.println("\n\n\n");
                    Menus.examType();
                } else if (name.equals("e")) {
                    Run.exit();
                } else {
                    System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET +
                            TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] +
                            TEXT_RESET + "  " + '\u2260' + "  " +
                            TEXT_RED + name + TEXT_RESET);
                    if (!(checkMistakes.contains(wordNumber))) {
                        checkMistakes.add(wordNumber);
                    }
                    ++error;
                }
            }
        }
        while (Menus.cases > 0);
        LocalTime finishTime = LocalTime.now();
    }

    public static int randomNumber(int Number) {
        boolean check = true;
        int resultRandom = 0;
        while (check) {
//            System.out.println("кол-во примеров: " + Number);
            double x = Math.random();
//            resultRandom1 = randomNumber(Number);
            resultRandom = (int) Math.round(x * Number);
//            System.out.println("Рандомное число: " + x);
//            System.out.println("Округленное рандомное число: " + Math.round(x));
//            System.out.println("Инт результата" + resultRandom);
//            System.out.println((int)resultRandom);
//            if (resultRandom1 > 0) {
//                check = false;
//            }

            if (resultRandom > 0) {
                check = false;
            }
        }
        return resultRandom;
    }

    public static void exit() {
        System.out.println("Thank you for using our application.");
        System.exit(0);
    }
}


