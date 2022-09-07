public class Graphics {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";

    public static void title() {

        String l = String.valueOf('\u066D');
        String l15 = l + l + l + l + l + l + l + l + l + l + l + l + l + l + l;
        System.out.println(TEXT_PURPLE + l15 + l15 + l15 + l15);
        System.out.print(l15);
        System.out.print("  STUDY SOME IRREGULAR VERBS  ");
        System.out.println(l15);
        System.out.println(l15 + l15 + l15 + l15 + TEXT_RESET + "\n\n");
    }

    //My new method for draw two words with frame
    public static void frameForTwoVariants(String variant1, String variant2) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        String hsVariant1 = "";
        for (int i = 0; i < variant1.length() + 2; i++){
            hsVariant1+=hs;
        }
        String hsVariant2 = "";
        for (int i = 0; i < variant2.length() + 2; i++){
            hsVariant2+=hs;
        }


        System.out.println(luc + hsVariant1 + ruc + "     " + luc + hsVariant2 + ruc);
        System.out.println(vs + " " + variant1 + " " + vs + "     " + vs + " " + variant2 + " " + vs);
        System.out.println(ldc + hsVariant1 + rdc + "     " + ldc + hsVariant2 + rdc);
    }
}
