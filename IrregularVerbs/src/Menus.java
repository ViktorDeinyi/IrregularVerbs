import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    public static String askExamType;
    public static String askLearningType;
    public static String askSuperQuiz;
    public static String askLevelOfDifficult;
    public static boolean complexity;
    public static String[][] active;


    public static int cases = 0;
    static public Scanner sc = new Scanner(System.in);


    public static void askAboutRegistration() {
        System.out.println("\nWould you like to use program with the name or incognito?");
        Graphics.frameRegistration("1.WITH NAME", "2.PRIVATE ");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.next();
        sc.nextLine();
        if (userAnswer.equals("1")) {
            askNewOrExist();
        } else if (userAnswer.equals("2")) {
            learningType();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

    public static void askNewOrExist() {
        System.out.println("\nYou can enter a new one or use name from previous sessions");
        Graphics.frameNewOld("1.NEW", "2.OLD");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.next();
        sc.nextLine();
        if (userAnswer.equals("1")) {
            Files.newFFile();
        } else if (userAnswer.equals("2")) {
            userMenu();
        } else if (askLearningType.equals("0")) {
            askAboutRegistration();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

    public static void userMenu() {
        System.out.println("\nEnter name of existing user");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        sc.nextLine();
        if (Files.userIsExist(userName)) {
            Files.newFFile();
        } else {
            System.out.println("There is no user with such name would you like to create new (1), or try to choose another? (2)");
            String newOne = sc.next();
            sc.nextLine();
            if (newOne.equals("1")) {
                Files.newFFile();
            } else if (askLearningType.equals("2")) {
                userMenu();
            } else if (askLearningType.equals("0")) {
                askNewOrExist();
            } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
                Run.exit();
            } else {
                System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
            }

        }
    }
    public static void anotherNew () {
        System.out.println("This name already exist");
        System.out.println("\n\t[TRY ANOTHER ONE (1)]\t\t[START WITHOUT NAME (2)]\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");String nextStep = sc.next();
        String ns = sc.next();
        sc.nextLine();
        if (ns.equals("1")) {
            Files.newFFile();
        } else if (ns.equals("2")) {
            learningType();
        } else if (ns.equals("0")) {
            Menus.examType();
        } else if (ns.equals("e") || nextStep.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }
    public static void anotherOld ()
    {}

    public static void learningType() {
        //выбор вида обучения
        System.out.println("\t\t\tSelect the type of learning ");
        Graphics.frameLearningType("1.LESSON  ", "2.EXAM   ", "3.SUPER QUIZ");
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
            System.out.println(Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
            System.out.println("The game goes to the first mistake. \n \t\t\tGood luck.  May the force be with you ...\n");
            superQuizInfo();
        } else if (askLearningType.equals("0")) {
            askAboutRegistration();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
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
        Graphics.frameExamType("1.INF \u2192 UKR ", "2.UKR \u2192 INF ", "3.INF\u2192 V2+V3", "4.UKR\u2192V1V2V3");
        askExamType = sc.next();
        sc.nextLine();
        if (askExamType.equals("1")) {
            System.out.println("Translate " + Run.V1 + " \u2192 " + Run.UKR);
            Run.checkNewTest = true;
            Run.examRun(0, 3, -1, -1, active);
        } else if (askExamType.equals("2")) {
            System.out.println("Translate " + Run.UKR + " \u2192 " + Run.V1);
            Run.checkNewTest = true;
            Run.examRun(3, 0, -1, -1, active);
        } else if (askExamType.equals("3")) {
            System.out.println("Translate " + Run.V1 + " \u2192 " + Run.V2 + " & " + Run.V3);
            System.out.println(Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
            Run.checkNewTest = true;
            Run.examRun(0, 1, 2, -1, active);
        } else if (askExamType.equals("4")) {
            System.out.println("Translate " + Run.UKR + " \u2192 " + Run.V1 + " & " + Run.V2 + " & " + Run.V3);
            System.out.println(Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
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
        System.out.println("\t\t\tHow many words would you like to have in exam? (1-" + (active.length - 1) + ")" + "\t\t\t\t\t\t" + "[RETURN (0)]");
        try {
            cases = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println("Хм, похоже ввели некорректный формат цифр ... \nДавай попробуем ввести правильно:");
            sc.nextLine();
            Menus.amountOfTests();
        }
        if (0 > cases || (active.length - 1) < cases) {
            System.out.println("Looks like we don't have enough words for this test. Please choose fewer.");
            Menus.amountOfTests();
        } else if (cases == 0) {
            examType();
        }
        System.out.println("Number of words in the exam is:" + cases + "\nLets Start...");

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
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
            superQuizInfo();
        }
    }

    //my new method about registration

}

