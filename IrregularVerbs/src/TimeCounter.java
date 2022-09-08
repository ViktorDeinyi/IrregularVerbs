
public class TimeCounter {
    public static String secondsIs;
    public static String minutesIs;
    public static String timeChange;

    public static void timeChange(int fh, int fm, int fs, int sh, int sm, int ss) {
        // calculate test time
        int diffTime = ((fh * 60) + (fm * 60) + fs) - ((sh * 60) + (sm * 60) + ss);
        if (diffTime >= 0 && diffTime < 3600) {
            secondsNameEn(diffTime);
            minutesNameEn(diffTime);
            System.out.print("The time you spent on the test was: ");
            System.out.println((diffTime / 60) + " " + minutesIs + " " + (diffTime%60) + " " + secondsIs);
            timeChange = "test time was :" + ((diffTime / 60) + " " + minutesIs + " : " + (diffTime%60) + " " + secondsIs);
        }
        else if (diffTime >= 3600)
            System.out.println("The time you spent on passing the test was more than an hour, maybe you should choose an easier level?");
        else if (diffTime < 0)
            timeChange(fh, fm, fs = fs + 86000, sh, sm, ss);
    }

    public static void secondsNameEn(int checkSeconds) {
        //correct display of seconds name Eng
        int checkSTime = checkSeconds % 60;
        if (checkSTime == 1 || checkSTime == 21 || checkSTime == 31 || checkSTime == 41 || checkSTime == 51)
            secondsIs = "second";
        else secondsIs = "seconds";
    }

    public static void minutesNameEn(int checkMinutes) {
        //correct display of minutes name Eng
        int checkMTime = checkMinutes / 60;
        if (checkMTime == 1 || checkMTime == 21 || checkMTime == 31 || checkMTime == 41 || checkMTime == 51)
            minutesIs = "minute";
        else minutesIs = "minutes";
    }

    public static void secondsNameRu(int checkSeconds) {
        //correct display of seconds name UA
        int checkSTime = checkSeconds % 60;
        if (checkSTime == 1 || checkSTime == 21 || checkSTime == 31 || checkSTime == 41 || checkSTime == 51)
            secondsIs = "секунда";
        else if (checkSTime == 2 || checkSTime == 22 || checkSTime == 32 || checkSTime == 42 || checkSTime == 52 || checkSTime == 3 || checkSTime == 23 || checkSTime == 33 || checkSTime == 43 || checkSTime == 53 || checkSTime == 4 || checkSTime == 24 || checkSTime == 34 || checkSTime == 44 || checkSTime == 54)
            secondsIs = "секунди";
        else secondsIs = "секунд";
    }

    public static void minutesNameRu(int checkMinutes) {
        //correct display of minutes name UA
        int checkMTime = checkMinutes / 60;
        if (checkMTime == 1 || checkMTime == 21 || checkMTime == 31 || checkMTime == 41 || checkMTime == 51)
            minutesIs = "хвилина";
        else if (checkMTime == 2 || checkMTime == 22 || checkMTime == 32 || checkMTime == 42 || checkMTime == 52 || checkMTime == 3 || checkMTime == 23 || checkMTime == 33 || checkMTime == 43 || checkMTime == 53 || checkMTime == 4 || checkMTime == 24 || checkMTime == 34 || checkMTime == 44 || checkMTime == 54)
            minutesIs = "хвилини";
        else minutesIs = "хвилин";
    }
}
