package io;

import java.util.Scanner;

public class p11_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String input = scanner.nextLine();
        int result = input.chars().reduce(0, (a, b) -> a + b - '0');
        System.out.println(result);
    }
}
