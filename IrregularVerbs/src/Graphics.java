public class Graphics {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String redHeart = TEXT_RED + "\u2665" + Run.TEXT_RESET;
    public static final String blackHeart = BLACK_BOLD + "\u2665" + Run.TEXT_RESET;

    public static final String luc = String.valueOf('\u250C');
    public static final String ruc = String.valueOf('\u2510');
    public static final String ldc = String.valueOf('\u2514');
    public static final String rdc = String.valueOf('\u2518');
    public static final String vs = String.valueOf('\u2502');
    public static final String hs = String.valueOf('\u2500');
    public static final String star = String.valueOf('\u066D');

    public static void title() {
        String l15 = star;
        for (int i=0;i<14; i++ ){
             l15 = l15 + star;}
        System.out.println(TEXT_PURPLE + l15 + l15 + l15 + l15);
        System.out.print(l15);
        System.out.print("  STUDY SOME IRREGULAR VERBS  ");
        System.out.println(l15);
        System.out.println(l15 + l15 + l15 + l15 + TEXT_RESET + "\n\n");
        System.out.println("\t\t\t\t\t\tHello!\n\tLet's start learning irregular verbs together!");
    }

    //My new method for draw two words with frame
    public static void frameRegistration(String var1, String var2) {
        String hsVar1 = "";
        for (int i = 0; i < var1.length() + 2; i++){
            hsVar1 +=hs;
        }
        String hsVar2 = "";
        for (int i = 0; i < var2.length() + 2; i++){
            hsVar2 +=hs;
        }

        System.out.println("\t\t"+luc + hsVar1 + ruc + "     " + luc + hsVar2 + ruc);
        System.out.println("\t\t"+vs + " " + var1 + " " + vs + "     " + vs + " " + var2 + " " + vs+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "[EXIT (E)]");
        System.out.println("\t\t"+ldc + hsVar1 + rdc + "     " + ldc + hsVar2 + rdc);
    }
    public static void frameNewOld(String var1, String var2) {
        String hsVar1 = "";
        for (int i = 0; i < var1.length() + 2; i++){
            hsVar1 +=hs;
        }
        String hsVar2 = "";
        for (int i = 0; i < var2.length() + 2; i++){
            hsVar2 +=hs;
        }

        System.out.println("\t\t"+luc + hsVar1 + ruc + "     " + luc + hsVar2 + ruc);
        System.out.println("\t\t"+vs + " " + var1 + " " + vs + "     " + vs + " " + var2 + " " + vs+ "\t\t\t\t\t\t\t\t\t\t\t" + "[RETURN (0)]" + "\t" + "[EXIT (E)]");
        System.out.println("\t\t"+ldc + hsVar1 + rdc + "     " + ldc + hsVar2 + rdc);
    }

    public static void frameLearningType(String var1, String var2, String var3) {
        //титулка меню выбора типа обучения
        String hsVar1 = "";
        for (int i = 0; i < var1.length() + 2; i++){
            hsVar1 +=hs;
        }
        String hsVar2 = "";
        for (int i = 0; i < var2.length() + 2; i++){
            hsVar2 +=hs;
        }
        String hsVar3 = "";
        for (int i = 0; i < var3.length() + 2; i++){
            hsVar3 +=hs;
        }

        String hs14 = hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs;
        System.out.println("\t"+luc + hsVar1 + ruc + "  " + luc + hsVar2 + ruc + "  " + luc + hsVar3 + ruc);
        System.out.println("\t"+vs + " " + var1 + " " + vs + "  " + vs + " " + var2 + " " + vs + "  " + vs + " " + var3 + " " + vs + "\t\t\t\t\t\t\t\t" + "[RETURN (0)]" + "\t" + "[EXIT (E)]");
        System.out.println("\t"+ldc + hsVar1 + rdc + "  " + ldc + hsVar2 + rdc + "  " + ldc + hsVar3 + rdc);
    }

    public static void frameExamType(String x, String y, String z, String q) {
        //титулка меню выбора вида экзамена

        String hs14 = hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs;
        System.out.println(luc + hs14 + ruc + "\t" + luc + hs14 + ruc + "\t" + luc + hs14 + ruc + "\t" + luc + hs14 + ruc);
        System.out.println(vs + " " + x + " " + vs + "\t" + vs + " " + y + " " + vs + "\t" + vs + " " + z + " " + vs + "\t" + vs + " " + q + " " + vs + "\t\t\t" + "[RETURN (0)]" + "\t" + "[EXIT (E)]");
        System.out.println(ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc);
    }
}