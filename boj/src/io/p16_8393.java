package io;

import java.util.Scanner;

public class p16_8393 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = sumOneToN(n);
        System.out.println("result = " + result);
    }

    private static int sumOneToN(int n) {
        return n * (n + 1) / 2;
    }
}
