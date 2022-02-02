package io;

import java.util.Scanner;

public class p4_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, a, b;
        t = scanner.nextInt();

        for(int i = 0; i < t; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(a + b);
        }
    }
}
