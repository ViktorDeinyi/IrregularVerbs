
public class TimeCounter {
    public static String secondsIs;
    public static String minutesIs;

    public static void timeChange(int fh, int fm, int fs, int sh, int sm, int ss) {
        // вычисляем время прохождения теста
        int diffTime = ((fh * 60) + (fm * 60) + fs) - ((sh * 60) + (sm * 60) + ss);
        if (diffTime >= 0 && diffTime < 3600) {
            secondsNameEn(diffTime);
            minutesNameEn(diffTime);
            System.out.print("The time you spent on the test was: ");
            System.out.println((diffTime / 60) + " " + minutesIs + " : " + (diffTime%60) + " " + secondsIs);
        }
        else if (diffTime >= 3600)
            System.out.println("The time you spent on passing the test was more than an hour, maybe you should choose an easier level?");
        else if (diffTime < 0)
            timeChange(fh, fm, fs = fs + 86000, sh, sm, ss);
    }

    public static void secondsNameEn(int checkSeconds) {
        //коректное отображение имени секунд Eng
        int checkSTime = checkSeconds % 60;
        if (checkSTime == 1 || checkSTime == 21 || checkSTime == 31 || checkSTime == 41 || checkSTime == 51)
            secondsIs = "second";
        else if (checkSTime == 2 || checkSTime == 22 || checkSTime == 32 || checkSTime == 42 || checkSTime == 52 || checkSTime == 3 || checkSTime == 23 || checkSTime == 33 || checkSTime == 43 || checkSTime == 53 || checkSTime == 4 || checkSTime == 24 || checkSTime == 34 || checkSTime == 44 || checkSTime == 54)
            secondsIs = "seconds";
        else secondsIs = "seconds";
    }

    public static void minutesNameEn(int checkMinutes) {
        //коректное отображение имени минут Eng
        int checkMTime = checkMinutes / 60;
        if (checkMTime == 1 || checkMTime == 21 || checkMTime == 31 || checkMTime == 41 || checkMTime == 51)
            minutesIs = "minute";
        else if (checkMTime == 2 || checkMTime == 22 || checkMTime == 32 || checkMTime == 42 || checkMTime == 52 || checkMTime == 3 || checkMTime == 23 || checkMTime == 33 || checkMTime == 43 || checkMTime == 53 || checkMTime == 4 || checkMTime == 24 || checkMTime == 34 || checkMTime == 44 || checkMTime == 54)
            minutesIs = "minutes";
        else minutesIs = "minutes";
    }

    public static void secondsNameRu(int checkSeconds) {
        //коректное отображение имени секунд RU
        int checkSTime = checkSeconds % 60;
        if (checkSTime == 1 || checkSTime == 21 || checkSTime == 31 || checkSTime == 41 || checkSTime == 51)
            secondsIs = "секунда";
        else if (checkSTime == 2 || checkSTime == 22 || checkSTime == 32 || checkSTime == 42 || checkSTime == 52 || checkSTime == 3 || checkSTime == 23 || checkSTime == 33 || checkSTime == 43 || checkSTime == 53 || checkSTime == 4 || checkSTime == 24 || checkSTime == 34 || checkSTime == 44 || checkSTime == 54)
            secondsIs = "секунды";
        else secondsIs = "секунд";
    }

    public static void minutesNameRu(int checkMinutes) {
        //коректное отображение имени минут RU
        int checkMTime = checkMinutes / 60;
        if (checkMTime == 1 || checkMTime == 21 || checkMTime == 31 || checkMTime == 41 || checkMTime == 51)
            minutesIs = "минута";
        else if (checkMTime == 2 || checkMTime == 22 || checkMTime == 32 || checkMTime == 42 || checkMTime == 52 || checkMTime == 3 || checkMTime == 23 || checkMTime == 33 || checkMTime == 43 || checkMTime == 53 || checkMTime == 4 || checkMTime == 24 || checkMTime == 34 || checkMTime == 44 || checkMTime == 54)
            minutesIs = "минуты";
        else minutesIs = "минут";
    }
}
