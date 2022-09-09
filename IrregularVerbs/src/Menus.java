import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    public static final String UKR = "(Ukrainian)";
    public static final String V1 = "(V1 Infinitive)";
    public static final String V2 = "(V2 Past Simple)";
    public static final String V3 = "(V3 Participle)";
    public static String askLearningType;
    public static String askLevelOfDifficult;
    public static String askExamType;
    public static String askSuperQuiz;

    public static String[][] activeDataMassive;

    public static String chosenExamType;

    public static int cases = 0;
    public static Scanner sc = new Scanner(System.in);


    public static void askAboutRegistration() {
        System.out.println("\nWould you like to use program with the name or incognito?");
        Graphics.frameRegistration("1.WITH NAME", "2.INCOGNITO");
        boolean checkWrongInput = false;
        do {
            String userAnswer = sc.next();
            sc.nextLine();
            switch (userAnswer) {
                case "1" -> askNewOrExist();
                case "2" -> {
                    Files.userNameOriginal = "NoStatistics";
                    learningType();
                }
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static void askNewOrExist() {
        System.out.println("\nYou can enter a new one or use name from previous sessions");
        Graphics.frameNewOld("1.NEW NAME ", "2.EXISTING ");
        boolean checkWrongInput = false;
        do {
            String userAnswer = sc.next();
            sc.nextLine();
            switch (userAnswer) {
                case "1" -> Files.newFFile();
                case "2" -> checkExistingUser();
                case "0" -> askAboutRegistration();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static void anotherNew() {
        Files.userNameOriginal = "NoStatistics";
        System.out.println("This name already exists");
        boolean checkWrongInput = false;
        do {
            System.out.println("\n\t[TRY ANOTHER (1)]\t\t[START INCOGNITO (2)]\t\t\t\t\t\t\t\t\t[GO BACK (0)]\t[EXIT (E)]");
            String userAnswer = sc.next();
            sc.nextLine();
            switch (userAnswer) {
                case "1" -> Files.newFFile();
                case "2" -> {
                    Files.userNameOriginal = "NoStatistics";
                    learningType();
                }
                case "0" -> askNewOrExist();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        }
        while (checkWrongInput);
    }

    public static void checkExistingUser() {
        System.out.println("\nEnter existing user`s name");
        String enterUserName = sc.next();
        sc.nextLine();
        if (Files.userIsExist(enterUserName)) {
            Files.userNameOriginal = enterUserName;
            System.out.println("\n\tHello " + Files.userNameOriginal);
            userMenu();
        } else {
            System.out.println("There is no user with such name ");
            boolean checkWrongInput = false;
            do {
                System.out.println("\n\t[CREATE NEW (1)]\t\t[CHOOSE ANOTHER (2)]\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
                String userAnswer = sc.next();
                sc.nextLine();
                switch (userAnswer) {
                    case "1" -> Files.newFFile();
                    case "2" -> checkExistingUser();
                    case "0" -> askNewOrExist();
                    case "e", "E" -> Run.exit();
                    default -> {
                        checkWrongInput = true;
                        System.out.println(Graphics.wrongInput);
                    }
                }
            } while (checkWrongInput);
        }
    }

    public static void userMenu() {
        System.out.println("\t\nWhat would you like to do?");
        boolean checkWrongInput = false;
        do {
            System.out.println("\n\t[START LESSON (1)]\t\t[CHECK STAT (2)]\t\t[CHOOSE NEW NAME (3)]\t\t\t\t[GO MAIN (0)]\t[EXIT (E)]");
            String userAnswer = sc.next();
            sc.nextLine();
            switch (userAnswer) {
                case "1" -> learningType();
                case "2" -> {
                    Files.readFile(Files.userNameOriginal);
                    userMenu();
                }
                case "3" -> checkExistingUser();
                case "0" -> askAboutRegistration();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }


    public static void learningType() {
        System.out.println("\t\t\tSelect the type of learning ");
        Graphics.frameLearningType("1.LESSON    ", "2.EXAM      ", "3.SUPER QUIZ");
        boolean checkWrongInput = false;
        do {
            askLearningType = sc.next();
            sc.nextLine();
            switch (askLearningType) {
                case "1" -> {
                    levelOfDifficult();
                    Run.lessonRun(activeDataMassive);
                }
                case "2" -> {
                    levelOfDifficult();
                    examType();
                }
                case "3" -> {
                    levelOfDifficult();
                    System.out.println("In this quiz you write the answer in the specified form of the given verb");
                    System.out.println(Run.TEXT_RED + "Some verbs in v2() & v3() have two meanings, please enter them using a spase " + Run.TEXT_RESET);
                    System.out.println("The game runs until you make three mistakes. \n \t\t\tGood luck!  May the force be with you ...\n");
                    superQuizInfo();
                }
                case "0" -> askAboutRegistration();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static void levelOfDifficult() {
        System.out.println("\t\t\tSelect the level of difficulty");
        Graphics.frameDifficultType("1.BASIC     ", "2.MEDIUM    ", "3.HARD      ");
        boolean checkWrongInput = false;
        do {
            askLevelOfDifficult = sc.next();
            sc.nextLine();
            switch (askLevelOfDifficult) {
                case "1" -> activeDataMassive = Data.getWords1();
                case "2" -> activeDataMassive = Data.getWords2();
                case "3" -> activeDataMassive = Data.getWords3();
                case "0" -> learningType();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }


    public static void examType() {
        System.out.println("\t\t\tSelect the type of test ");
        Graphics.frameExamType("1.INF \u2192 UKR ", "2.UKR \u2192 INF ", "3.INF \u2192 V2+V3", "4.UKR\u2192V1+V2+V3");
        boolean checkWrongInput = false;
        do {
            askExamType = sc.next();
            sc.nextLine();
            switch (askExamType) {
                case "1" -> {
                    chosenExamType = "Translate " + V1 + " \u2192 " + UKR;
                    System.out.println(chosenExamType);
                    Run.checkNewTest = true;
                    Run.examRun(0, 3, -1, -1, activeDataMassive);
                }
                case "2" -> {
                    chosenExamType = "Translate " + UKR + " \u2192 " + V1;
                    System.out.println(chosenExamType);
                    Run.checkNewTest = true;
                    Run.examRun(3, 0, -1, -1, activeDataMassive);
                }
                case "3" -> {
                    chosenExamType = "Translate " + V1 + " \u2192 " + V2 + " & " + V3;
                    System.out.println(chosenExamType);
                    System.out.println(Graphics.someWords);
                    Run.checkNewTest = true;
                    Run.examRun(0, 1, 2, -1, activeDataMassive);
                }
                case "4" -> {
                    chosenExamType = "Translate " + UKR + " \u2192 " + V1 + " & " + V2 + " & " + V3;
                    System.out.println(chosenExamType);
                    System.out.println(Graphics.someWords);
                    Run.checkNewTest = true;
                    Run.examRun(3, 0, 1, 2, activeDataMassive);
                }
                case "0" -> learningType();
                case "e", "E" -> Run.exit();
                default -> {
                    checkWrongInput = true;
                    System.out.println(Graphics.wrongInput);
                }
            }
        } while (checkWrongInput);
    }

    public static void amountOfTests() {
        //выбор кол-ва тестов
        System.out.println("\t\t\tHow many verbs would you like to have in exam? (1-" + (activeDataMassive.length - 1) + ")" + "\t\t\t\t\t\t" + "[RETURN (0)]");
        try {
            cases = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println(Graphics.TEXT_YELLOW + "Looks like you entered the wrong characters. Let`s try again... " + Graphics.TEXT_RESET);
            sc.nextLine();
            Menus.amountOfTests();
        }
        if (0 > cases || (activeDataMassive.length - 1) < cases) {
            System.out.println(Graphics.TEXT_YELLOW + "Looks like we don't have enough verbs for this test. Please choose less." + Graphics.TEXT_RESET);
            Menus.amountOfTests();
        } else if (cases == 0) {
            examType();
        }
        System.out.println("Number of verbs in the exam is: " + cases + "\nLet`s Start...");

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
            Run.superQuizRun(activeDataMassive);
        } else if (askSuperQuiz.equals("e") || askSuperQuiz.equals("E")) {
            Run.exit();
        } else {
            System.out.println(Graphics.TEXT_YELLOW + "Looks like you entered the wrong characters. Let`s try again... " + Graphics.TEXT_RESET);
            superQuizInfo();
        }
    }

    //my new method about registration

}

