package io;

import java.util.Scanner;

public class p17_10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            min = Math.min(min, input);
            max = Math.max(max, input);
        }
        System.out.println(min + " " + max);
    }
}
