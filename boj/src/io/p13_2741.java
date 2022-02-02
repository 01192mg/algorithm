package io;

import java.util.Scanner;
import java.util.stream.IntStream;

public class p13_2741 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        IntStream.range(1, input + 1).forEach(System.out::println);
    }
}
