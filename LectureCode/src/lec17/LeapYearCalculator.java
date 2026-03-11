package lec17;

public class LeapYearCalculator {

    public static boolean isLeapYear(int year) {
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            return false;
        }
        return isLeap;
    }

    public static boolean isLeapYear1(int year) {
        boolean isLeap = false;
        if (year % 4 == 0 && year % 100 != 0 ) {
            isLeap = true;
        }
        if (year % 400 == 0) {
            isLeap = true;
        }
        return isLeap;
    }
}