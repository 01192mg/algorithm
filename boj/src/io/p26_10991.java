package io;

import java.util.Scanner;

public class p26_10991 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if (n-1-i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 0; k < i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
