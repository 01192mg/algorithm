package io;

import java.util.Scanner;

public class p12_11721 {
    static final int INDEXING_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int firstIndex = 0;
        while (firstIndex + INDEXING_SIZE < input.length()) {
            String tmp = input.substring(firstIndex, firstIndex + INDEXING_SIZE);
            System.out.println(tmp);
            firstIndex += INDEXING_SIZE;
        }
        System.out.println(input.substring(firstIndex));
    }
}
