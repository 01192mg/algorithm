package io;

import java.util.Scanner;

public class p9_11022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, a, b;
        t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            String[] biNumber = input.split(" ");
            a = Integer.parseInt(biNumber[0]);
            b = Integer.parseInt(biNumber[1]);
            System.out.printf("Case #%d: %d + %d = %d\n", i + 1, a, b, (a + b));
        }
    }
}
