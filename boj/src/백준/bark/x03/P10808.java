package 백준.bark.x03;

import java.util.Scanner;

public class P10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] alpha = new int[26];
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}
