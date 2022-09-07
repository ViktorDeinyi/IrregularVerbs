import java.io.IOException;
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


    public static void learningType()  {
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
            System.out.println(IrregularVerbs.Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + IrregularVerbs.Run.TEXT_RESET);
            System.out.println("The game goes to the first mistake. \n \t\t\tGood luck.  May the force be with you ...\n");
            superQuizInfo();
        } else if (askLearningType.equals("0")) {
            askAboutRegistration();
        } else if (askLearningType.equals("e") || askLearningType.equals("E")) {
            IrregularVerbs.Run.exit();
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
            System.out.println("Translate " + IrregularVerbs.Run.V1 + " \u2192 " + IrregularVerbs.Run.UKR);
            Run.checkNewTest=true;
            IrregularVerbs.Run.examRun(0, 3, -1, -1, active);
        } else if (askExamType.equals("2")) {
            System.out.println("Translate " + IrregularVerbs.Run.UKR + " \u2192 " + IrregularVerbs.Run.V1);
            Run.checkNewTest=true;
            IrregularVerbs.Run.examRun(3, 0, -1, -1, active);
        } else if (askExamType.equals("3")) {
            System.out.println("Translate " + IrregularVerbs.Run.V1 + " \u2192 " + IrregularVerbs.Run.V2 + " & " + IrregularVerbs.Run.V3);
            System.out.println(IrregularVerbs.Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + IrregularVerbs.Run.TEXT_RESET);
            Run.checkNewTest=true;
            IrregularVerbs.Run.examRun(0, 1, 2, -1, active);
        } else if (askExamType.equals("4")) {
            System.out.println("Translate " + IrregularVerbs.Run.UKR + " \u2192 " + IrregularVerbs.Run.V1 + " & " + IrregularVerbs.Run.V2 + " & " + IrregularVerbs.Run.V3);
            System.out.println(IrregularVerbs.Run.TEXT_RED + "Some words in v2() & v3() have two meanings, please enter them using a spase " + IrregularVerbs.Run.TEXT_RESET);
            Run.checkNewTest=true;
            IrregularVerbs.Run.examRun(3, 0, 1, 2, active);
        } else if (askExamType.equals("0")) {
            learningType();
        } else if (askExamType.equals("e") || askExamType.equals("E")) {
            IrregularVerbs.Run.exit();
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
            IrregularVerbs.Run.superQuizRun(active);
        } else if (askSuperQuiz.equals("e") || askSuperQuiz.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
            superQuizInfo();
        }
    }
    
    //my new method about registration
    public static boolean askAboutRegistration() {
        System.out.println("                 Hello!\nLet's start learning irregular verbs together!");
        System.out.println();
        while(true) {
            System.out.println("Would you like to register?  ");
            Graphics.frameForTwoVariants("1.YES", "2.NO");
            Scanner sc = new Scanner(System.in);
            byte userAnswer = sc.nextByte();
            if (userAnswer == 1) {
                return true;
            } else if (userAnswer == 2) {
                return false;
            } else {
                System.out.println("Your answer is not correct. Try again.");
                System.out.println();
            }
        }
    }
}

