import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    public static String askExamType;
    public static String askLearningType;
    public static String askSuperQuiz;
    public static String askLevelOfDifficult;
    public static boolean complexity;
    public static String[][] active;

    public static String chosenExamType;

    public static int cases = 0;
    static public Scanner sc = new Scanner(System.in);


    public static void askAboutRegistration() {
        System.out.println("\nWould you like to use program with the name or incognito?");
        Graphics.frameRegistration("1.WITH NAME", "2.INCOGNITO");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.next();
        sc.nextLine();
        if (userAnswer.equals("1")) {
            askNewOrExist();
        } else if (userAnswer.equals("2")) {
            Files.userNameOriginal = "NoStatistics";
            learningType();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+ Graphics.TEXT_RESET);
        }
    }

    public static void askNewOrExist() {
        System.out.println("\nYou can enter a new one or use name from previous sessions");
        Graphics.frameNewOld("1.NEW NAME ", "2.EXISTING ");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.next();
        sc.nextLine();
        if (userAnswer.equals("1")) {
            Files.newFFile();
        } else if (userAnswer.equals("2")) {
            checkExistingUser();
        } else if (askLearningType.equals("0")) {
            askAboutRegistration();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+ Graphics.TEXT_RESET);
        }
    }

    public static void checkExistingUser() {
        System.out.println("\nEnter existing user`s name");
        Scanner sc = new Scanner(System.in);
        String enterUserName = sc.next();
        sc.nextLine();
        if (Files.userIsExist(enterUserName)) {
            Files.userNameOriginal = enterUserName;
            System.out.println("\n\tHello " + Files.userNameOriginal);
            userMenu();
        } else {
            System.out.println("There is no user with such name ");
            System.out.println("\n\t[CREATE NEW (1)]\t\t[CHOOSE ANOTHER (2)]\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
            String newOne = sc.next();
            sc.nextLine();
            if (newOne.equals("1")) {
                Files.newFFile();
            } else if (newOne.equals("2")) {
                checkExistingUser();
            } else if (newOne.equals("0")) {
                askNewOrExist();
            } else if (newOne.equals("e") || askLearningType.equals("E")) {
                Run.exit();
            } else {
                System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+ Graphics.TEXT_RESET);
            }
        }
    }


    public static void userMenu() {
        System.out.println("\t\nWhat would you like to do?");
        System.out.println("\n\t[START LESSON (1)]\t\t[CHECK STATISTICS (2)]\t\t[CHOOSE NEW NAME (3)]\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String choose = sc.next();
        sc.nextLine();
        if (choose.equals("1")) {
            learningType();
        } else if (choose.equals("2")) {
            Files.readFile(Files.userNameOriginal);
            userMenu();
        } else if (choose.equals("3")) {
            checkExistingUser();
        } else if (choose.equals("0")) {
            askNewOrExist();
        } else if (choose.equals("e") || choose.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+Graphics.TEXT_RESET);
        }

    }

    public static void anotherNew() {
        Files.userNameOriginal = "NoStatistics";
        System.out.println("This name already exists");
        System.out.println("\n\t[TRY ANOTHER (1)]\t\t[START WITHOUT NAME (2)]\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String ns = sc.next();
        sc.nextLine();
        if (ns.equals("1")) {
            Files.newFFile();
        } else if (ns.equals("2")) {
            Files.userNameOriginal = "NoStatistics";
            learningType();
        } else if (ns.equals("0")) {
            askNewOrExist();
        } else if (ns.equals("e") || ns.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+Graphics.TEXT_RESET);
        }
    }

    public static void anotherOld() {
    }

    public static void learningType() {
        //выбор вида обучения
        System.out.println("\t\t\tSelect the type of learning ");
        Graphics.frameLearningType("1.LESSON    ", "2.EXAM      ", "3.SUPER QUIZ");
        askLearningType = sc.next();
        if (askLearningType.equals("1")) {
            complexity = false;
            levelOfDifficult(complexity);
            Run.lessonRun(active);
        } else if (askLearningType.equals("2")) {
            complexity = true;
            levelOfDifficult(complexity);
            examType();
        } else if (askLearningType.equals("3")) {
            complexity = true;
            levelOfDifficult(complexity);
            System.out.println("In this quiz you write the answer in the specified form of the given verb");
            System.out.println(Run.TEXT_RED + "Some verbs in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
            System.out.println("The game runs until you make three mistakes. \n \t\t\tGood luck!  May the force be with you ...\n");
            superQuizInfo();
        } else if (askLearningType.equals("0")) {
            askAboutRegistration();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+Graphics.TEXT_RESET);
            Menus.learningType();
        }

    }

    public static void levelOfDifficult(boolean complexity) {
        //выбор уровня сложности
        System.out.println("\t\t\tSelect the level of difficulty");
        Graphics.frameLearningType("1.BASIC     ", "2.MEDIUM    ", "3.HARD      ");
        askLevelOfDifficult = sc.next();
        if (askLevelOfDifficult.equals("1")) {
            active = Data.getWords1();
            if (complexity) {
            }
        } else if (askLevelOfDifficult.equals("2")) {
            active = Data.getWords2();
            if (complexity) {
            }
        } else if (askLevelOfDifficult.equals("3")) {
            active = Data.getWords3();
            if (complexity) {
            }
        } else if (askLevelOfDifficult.equals("0")) {
            learningType();
        } else if (askLevelOfDifficult.equals("e") || askLevelOfDifficult.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
            Menus.learningType();
        }

    }


    public static void examType() {
        //выбор типа экзамена
        System.out.println("\t\t\tSelect the type of test ");
        Graphics.frameExamType("1.INF \u2192 UKR ", "2.UKR \u2192 INF ", "3.INF \u2192 V2+V3", "4.UKR\u2192V1+V2+V3");
        askExamType = sc.next();
        sc.nextLine();
        if (askExamType.equals("1")) {
            chosenExamType = "Translate " + Run.V1 + " \u2192 " + Run.UKR;
            System.out.println(chosenExamType);
            Run.checkNewTest = true;
            Run.examRun(0, 3, -1, -1, active);
        } else if (askExamType.equals("2")) {
            chosenExamType = "Translate " + Run.UKR + " \u2192 " + Run.V1;
            System.out.println(chosenExamType);
            Run.checkNewTest = true;
            Run.examRun(3, 0, -1, -1, active);
        } else if (askExamType.equals("3")) {
            chosenExamType = "Translate " + Run.V1 + " \u2192 " + Run.V2 + " & " + Run.V3;
            System.out.println(chosenExamType);
            System.out.println(Run.TEXT_RED + "Some verbs in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
            Run.checkNewTest = true;
            Run.examRun(0, 1, 2, -1, active);
        } else if (askExamType.equals("4")) {
            chosenExamType = "Translate " + Run.UKR + " \u2192 " + Run.V1 + " & " + Run.V2 + " & " + Run.V3;
            System.out.println(chosenExamType);
            System.out.println(Run.TEXT_RED + "Some verbs in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
            Run.checkNewTest = true;
            Run.examRun(3, 0, 1, 2, active);
        } else if (askExamType.equals("0")) {
            learningType();
        } else if (askExamType.equals("e") || askExamType.equals("E")) {
            Run.exit();
        } else System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        Menus.examType();
    }

    public static void amountOfTests() {
        //выбор кол-ва тестов
        System.out.println("\t\t\tHow many verbs would you like to have in exam? (1-" + (active.length - 1) + ")" + "\t\t\t\t\t\t" + "[RETURN (0)]");
        try {
            cases = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like you entered the wrong characters. Let`s try again... "+Graphics.TEXT_RESET);
            sc.nextLine();
            Menus.amountOfTests();
        }
        if (0 > cases || (active.length - 1) < cases) {
            System.out.println(Graphics.TEXT_YELLOW+"Looks like we don't have enough verbs for this test. Please choose less."+ Graphics.TEXT_RESET);
            Menus.amountOfTests();
        } else if (cases == 0) {
            examType();
        }
        System.out.println("Number of verbs in the exam is:" + cases + "\nLet`s Start...");

    }

    public static void superQuizInfo() {
        //инфо квиза
        Scanner sc = new Scanner(System.in);
        System.out.println("[LET`S ROCK (1)] \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[NOT SURE ANYMORE (0)]");
        askSuperQuiz = sc.next();
        sc.nextLine();
        if (askSuperQuiz.equals("0")) {
            Menus.learningType();
        } else if (askSuperQuiz.equals("1")) {
            Run.superQuizRun(active);
        } else if (askSuperQuiz.equals("e") || askSuperQuiz.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW +"Looks like you entered the wrong characters. Let`s try again... " + Graphics.TEXT_RESET);
            superQuizInfo();
        }
    }

    //my new method about registration

}

