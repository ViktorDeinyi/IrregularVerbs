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

}
