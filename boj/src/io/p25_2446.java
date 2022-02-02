package io;

import java.util.Scanner;

public class p25_2446 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < n; j++) {
                if (n-1-i > j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (n-1-i <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
