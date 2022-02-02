package io;

import java.util.Scanner;

public class p15_1924 {
    final static int[] DAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final static String[] WEEKDAY = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] date = scanner.nextLine().split(" ");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);

        int days = calcDays(month, day);
        String weekday = weekday(days);
        System.out.println(weekday);
    }

    private static String weekday(int days) {
        return WEEKDAY[days % 7];
    }

    private static int calcDays(int month, int day) {
        int result = 0;
        for (int i = 0; i < month - 1; i++) {
            result += DAYS[i];
        }
        return result + day - 1;
    }
}
