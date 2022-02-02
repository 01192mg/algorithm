package io;

import java.util.Scanner;

public class p20_2440 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
