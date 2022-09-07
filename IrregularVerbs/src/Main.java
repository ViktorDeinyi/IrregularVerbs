public class Main {
    public static void main(String[] args) {
        Graphics.title();
        boolean wantToRegister = Menus.askAboutRegistration();
        if (wantToRegister){
            NewFile.main(new String[]{""});
        }
    }
}
