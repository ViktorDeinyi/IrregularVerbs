import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class Run {

    public static Map<Integer, String> names = Map.of(
            0, "(V1 Infinitive)",
            1, "(V2 Past Simple)",
            2, "(V3 Participle)",
            3, "(Ukrainian)");

    public static Scanner sc = new Scanner(System.in);
    int[] checkOriginal;
    public static boolean checkNewTest = true;
    public static String answer;

    public static void lessonRun(String[][] activeMassive) {
        System.out.println("Choose number of verbs you would like to learn ");
        System.out.println("\t[1-10 (1)]\t\t[11-20 (2)]\t\t[21-30 (3)]\t\t[31-40 (4)]\t\t[41-50 (5)]\t\t\t[GO BACK (0)]");
        byte amountOfVerbs = 0;
        try {
            amountOfVerbs = sc.nextByte();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println(Graphics.wrongInput);
            sc.nextLine();
            lessonRun(activeMassive);
        }
        if (amountOfVerbs == 1) {
            System.out.println("  INF,  V1,  V2,  UKR");
            for (int i = 1; i < 11; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 2) {
            System.out.println("  INF,  V1,  V2,  UKR");
            for (int i = 11; i < 21; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 3) {
            System.out.println("  INF,  V1,  V2,  UKR");
            for (int i = 21; i < 31; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 4) {
            System.out.println("  INF,  V1,  V2,  UKR");
            for (int i = 31; i < 41; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 5) {
            System.out.println("  INF,  V1,  V2,  UKR");
            for (int i = 41; i < 51; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 0) {
            Menus.learningType();
        } else {
            System.out.print(Graphics.TEXT_YELLOW + "Sorry, we don't have enough cases for this lesson. ");
            System.out.println("Please choose the number between 1-5 to start learning.\n" + Graphics.TEXT_RESET);
            lessonRun(activeMassive);
        }
        System.out.println("\n" + "What you would like to do next? :  ");
        boolean checkWrongInput = false;
        do {
            System.out.println("\t[Learn another verbs (1)]\t\t[Take a quiz with learned verbs (2)]\t\t\t\t[GO BACK (0)]\t[EXIT (E)]");
            String userChoose = sc.next();
            sc.nextLine();
            switch (userChoose) {
                case "1" -> lessonRun(activeMassive);
                case "2" -> examRunL(3, 0, 1, 2, activeMassive, amountOfVerbs);
                case "0" -> Menus.learningType();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static void examRunL(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive, int amountOfVerbs) {
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        int index = 0;
        int cases = 10;
        double error = 0;
        int[] checkOriginal = new int[cases];
        do {
            cases--;
            int wordNumber = randomNumber(checkOriginal.length) + ((amountOfVerbs * 10) - 10);
            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(checkOriginal.length) + ((amountOfVerbs * 10) - 10);
                    i = -1;
                }
                ++i;
            }
            checkOriginal[index] = wordNumber;
            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
            for (int x = 1; x <= 3; ++x) {
                String name;
                do {
                    System.out.print("\n" + index + "/" + checkOriginal.length + "\t");
                    System.out.print(names.get(indexAnswers[0]) + "\t" + activeMassive[wordNumber][indexAnswers[0]]);
                    System.out.print("  =  " + names.get(indexAnswers[x]) + "  ");
                    name = sc.nextLine();
                    name = name.toLowerCase();
                    if (name.isEmpty())
                        System.out.println(Graphics.typeAnswer);
                } while (name.isEmpty());
                if (activeMassive[wordNumber][indexAnswers[x]].equals(name)) {
                    System.out.println("Correct: " + Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]]
                            + Graphics.TEXT_RESET + "  =  " + Graphics.TEXT_GREEN + name + Graphics.TEXT_RESET);
                } else if (name.equals("0")) {
                    System.out.println("\n\n\n");
                    Menus.learningType();
                } else if (name.equals("e")) {
                    Run.exit();
                } else {
                    System.out.println(Graphics.TEXT_RED + "Mistake: " + Graphics.TEXT_RESET +
                            Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + Graphics.TEXT_RESET
                            + "  " + '\u2260' + "  " + Graphics.TEXT_RED + name + Graphics.TEXT_RESET);
                    ++error;
                }
            }
        }
        while (cases > 0);

        System.out.println("\n" + "What you would like to do next? :  ");
        boolean checkWrongInput = false;
        do {
            System.out.println("\t[Learn another verbs (1)]\t\t[Take a quiz with learned words (2)]\t\t\t\t[GO BACK (0)]\t[EXIT (E)]");
            String userChoose = sc.next();
            sc.nextLine();
            {
                switch (userChoose) {
                    case "1" -> lessonRun(activeMassive);
                    case "2" -> examRunL(3, 0, 1, 2, activeMassive, amountOfVerbs);
                    case "0" -> Menus.learningType();
                    case "e", "E" -> Run.exit();
                    default -> {
                        checkWrongInput = true;
                        System.out.println(Graphics.wrongInput);
                    }
                }
            }
        } while (checkWrongInput);
    }

    public static void examRun(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive) {
        if (checkNewTest) {
            Menus.amountOfTests();
        }
        System.out.println("Number of verbs in the exam is: " + Menus.cases + "\nLet`s Start...");
        byte amountOfAnswers = 3;
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        for (int w = 0; indexAnswers.length > w; w++) {
            if (indexAnswers[w] < 0) amountOfAnswers--;
        }
//        System.out.println(Menus.cases);
        int index = 0;
        double error = 0;
        int[] checkOriginal = new int[Menus.cases];
        ArrayList<Integer> checkMistakes = new ArrayList<>();
        LocalTime startTime = LocalTime.now();
        do {
            Menus.cases--;
            int wordNumber = randomNumber(activeMassive.length - 1);
            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(activeMassive.length - 1);
                    i = -1;
                }
                ++i;
            }
            checkOriginal[index] = wordNumber;
            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
            for (int x = 1; x <= amountOfAnswers; ++x) {
                String name;
                do {
                    System.out.print("\n" + index + "/" + checkOriginal.length + "\t");
                    System.out.print(names.get(indexAnswers[0]) + "\t" + activeMassive[wordNumber][indexAnswers[0]]);
                    System.out.print("  =  " + names.get(indexAnswers[x]) + "  ");
                    name = sc.nextLine();
                    name = name.toLowerCase();
                    // Check that the line is empty
                    if (name.isEmpty())
                        System.out.println(Graphics.typeAnswer);
                } while (name.isEmpty());
                if (activeMassive[wordNumber][indexAnswers[x]].equals(name)) {
                    System.out.println("Correct: " +
                            Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + Graphics.TEXT_RESET + "  =  " +
                            Graphics.TEXT_GREEN + name + Graphics.TEXT_RESET);
                } else if (name.equals("0")) {
                    System.out.println("\n\n\n");
                    Menus.examType();
                } else if (name.equals("e")) {
                    Run.exit();
                } else {
                    System.out.println(Graphics.TEXT_RED + "Mistake: " + Graphics.TEXT_RESET +
                            Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] +
                            Graphics.TEXT_RESET + "  " + '\u2260' + "  " +
                            Graphics.TEXT_RED + name + Graphics.TEXT_RESET);
                    if (!(checkMistakes.contains(wordNumber))) {
                        checkMistakes.add(wordNumber);
                    }
                    ++error;
                }
            }
        }
        while (Menus.cases > 0);
        LocalTime finishTime = LocalTime.now();
        //creating an array of passed test words
        String[][] correct = new String[checkOriginal.length + 1][4];
        correct[0][0] = activeMassive[0][0];
        correct[0][1] = activeMassive[0][1];
        correct[0][2] = activeMassive[0][2];
        correct[0][3] = activeMassive[0][3];
        for (int i = 0; i < checkOriginal.length; i++) {
            int x = checkOriginal[i];
            for (int j = 0; j < 4; j++) {
                correct[i + 1][j] = activeMassive[x][j];
            }
        }
        //creating an array of test words with mistakes
        String[][] mistakes = new String[checkMistakes.size() + 1][4];
        mistakes[0][0] = activeMassive[0][0];
        mistakes[0][1] = activeMassive[0][1];
        mistakes[0][2] = activeMassive[0][2];
        mistakes[0][3] = activeMassive[0][3];
        for (int i = 0; i < checkMistakes.size(); i++) {
            int x = checkMistakes.get(i);
            for (int j = 0; j < 4; j++) {
                mistakes[i + 1][j] = activeMassive[x][j];
            }
        }
        //start and end time handling
        int fh = finishTime.getHour();
        int sh = startTime.getHour();
        int fm = finishTime.getMinute();
        int sm = startTime.getMinute();
        int fs = finishTime.getSecond();
        int ss = startTime.getSecond();

        //result processing
        double result = (((checkOriginal.length) * amountOfAnswers) - error) / (checkOriginal.length * amountOfAnswers) * 100;
        result = Math.rint(result);
        byte correctAnswersExam = (byte) (index * amountOfAnswers - error);
        System.out.println("\nYour test results: ");
        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);
        System.out.println("Number of correct answers: " + correctAnswersExam + "/" + index * amountOfAnswers);
        if (result >= 80) {
            System.out.println("Percentage of correct answers " + Graphics.TEXT_GREEN + result + " %" + Graphics.TEXT_RESET);
        } else if (result >= 40) {
            System.out.println("Percentage of correct answers: " + Graphics.TEXT_YELLOW + result + " %" + Graphics.TEXT_RESET);
        } else if (result >= 0) {
            System.out.println("Percentage of correct answers: " + Graphics.TEXT_RED + result + " %" + Graphics.TEXT_RESET + "\n\n");
        }
        //save statistics to a file
        Date dateTimeExam = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        if ((!(Files.userNameOriginal.equals("NoStatistics"))) && checkNewTest)
            Files.writeToFile(Files.userNameOriginal, dateFormat.format(dateTimeExam) + " " + Menus.chosenExamType
                    + " " + TimeCounter.timeChange + ".  Mistakes = " + correctAnswersExam + "/" + index * amountOfAnswers
                    + ". Percentage of correct answers = " + result + " %.\n");

        //exit menu
        String buttonWorkOnError = "[WORK ON MISTAKES (3)]";
        String buttonUsersMenu = "[USER`S MENU (4)]";
        String emptyButton = "\t\t";
        String emptyButton1 = "\t\t\t\t\t";
        boolean checkWrongInput = false;
        do {
            if (Files.userNameOriginal.equals("NoStatistics")) {
                buttonUsersMenu = emptyButton;
            }
            if (error == 0) {
                buttonWorkOnError = emptyButton1;
            }
            System.out.println("\n\t[TRY NEW (1)]\t[TRY SAME (2)]\t" + buttonWorkOnError + "\t\t\t" + buttonUsersMenu + "\t[GO BACK (0)]\t[EXIT (E)]");
            String nextStep = sc.next();
            sc.nextLine();
            switch (nextStep) {
                case "1":
                    checkNewTest = true;
                    Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, Menus.activeDataMassive);
                    break;
                case "2":
                    checkNewTest = false;
                    Menus.cases = correct.length - 1;
                    System.out.println(Menus.cases);
                    Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, correct);
                    break;
                case "3":
                    if (error == 0) {
                        checkWrongInput = true;
                        System.out.println(Graphics.wrongInput);
                    } else {
                        System.out.println(Graphics.TEXT_GREEN + "Let's go working with your mistakes: " + Graphics.TEXT_RESET + "\n");
                        checkNewTest = false;
                        Menus.cases = mistakes.length - 1;
                        Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, mistakes);
                    }
                    break;
                case "4":
                    if (Files.userNameOriginal.equals("NoStatistics")) {
                        checkWrongInput = true;
                        System.out.println(Graphics.wrongInput);
                    } else {
                        System.out.println("Ок " + Files.userNameOriginal);
                        Menus.userMenu();
                    }
                    break;
                case "0":
                    Menus.examType();
                    break;
                case "e":
                case "E":
                    Run.exit();
                    break;
                default:
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                    break;
            }
        }
        while (checkWrongInput);
    }

    public static void superQuizRun(String[][] activeMassive) {
        LocalTime startTime = LocalTime.now();
        byte error = 3;
        boolean check = true;
        int index = 0;
        String life1 = Graphics.redHeart;
        String life2 = Graphics.redHeart;
        do {
            int wordNumber = randomNumber(activeMassive.length - 1);
            int indexAnswer1 = randomNumber(3) - 1;
//            System.out.println(indexAnswer1);
            switch (indexAnswer1) {
                case 0 -> answer = Menus.V1;
                case 1 -> answer = Menus.V2;
                case 2 -> answer = Menus.V3;
            }

            String name;
            do {
                System.out.print("\n" + ++index + ". " + life1 + " " + life2 + " " + Graphics.redHeart + " "
                        + Menus.UKR + "  " + activeMassive[wordNumber][3] + "  =  " + answer + "  ");
                name = sc.nextLine();
                name = name.toLowerCase();
                if (name.isEmpty()) {
                    --index;
                    System.out.println(Graphics.typeAnswer);
                }
            } while (name.isEmpty());
            if (activeMassive[wordNumber][indexAnswer1].equals(name)) {
                System.out.println("Correct: " + Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + Graphics.TEXT_RESET
                        + "  =  " + Graphics.TEXT_GREEN + name + Graphics.TEXT_RESET);
            } else {
                System.out.println(Graphics.TEXT_RED + "Mistake: " + Graphics.TEXT_RESET
                        + Graphics.TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + Graphics.TEXT_RESET
                        + "  " + '\u2260' + "  " + Graphics.TEXT_RED + name + Graphics.TEXT_RESET);
                if (error == 3) {
                    life1 = Graphics.blackHeart;
                    System.out.println(Graphics.TEXT_YELLOW + "\nOops, your answer is wrong " + Graphics.TEXT_RESET);
                } else if (error == 2) {
                    life2 = Graphics.blackHeart;
                    System.out.println(Graphics.TEXT_YELLOW + "\nBe careful, you have only one mistake left " + Graphics.TEXT_RESET);
                }
                error--;
            }
        }
        while (error > 0);
        LocalTime finishTime = LocalTime.now();
        int fh = finishTime.getHour();
        int sh = startTime.getHour();
        int fm = finishTime.getMinute();
        int sm = startTime.getMinute();
        int fs = finishTime.getSecond();
        int ss = startTime.getSecond();

//result processing
        System.out.println("\nYour test results: ");
        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);
        if (index >= 100) {
            System.out.println("Correct answers: " + Graphics.TEXT_GREEN + (index - 3) + Graphics.TEXT_RESET);
        } else if (index >= 50) {
            System.out.println("Correct answers: " + Graphics.TEXT_YELLOW + (index - 3) + Graphics.TEXT_RESET);
        } else if (index >= 0) {
            System.out.println("Correct answers: " + Graphics.TEXT_RED + (index - 3) + Graphics.TEXT_RESET + "\n\n");
        }
        boolean checkWrongInput = false;
        do {
            System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[GO BACK (0)]\t[EXIT (E)]");
            String nextStep = sc.next();
            switch (nextStep) {
                case "1" -> superQuizRun(activeMassive);
                case "0" -> Menus.learningType();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static int randomNumber(int Number) {
        boolean check = true;
        int resultRandom = 0;
        while (check) {
            double x = Math.random();
            resultRandom = (int) Math.round(x * Number);
            if (resultRandom > 0) {
                check = false;
            }
        }
        return resultRandom;
    }

    public static void exit() {
        Graphics.endLine();
        System.exit(0);
    }
}
