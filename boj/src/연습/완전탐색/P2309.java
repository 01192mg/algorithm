package 연습.완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
    static StringBuilder sb = new StringBuilder();
    static int[] height = new int[10];
    static int[] selected = new int [8];
    static boolean[] used = new boolean[10];
    static boolean end = false;

    public static void main(String[] args) {
        input();
        rec(1, 0);
        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 9; i++) {
            height[i] = sc.nextInt();
        }
        Arrays.sort(height);
    }

    private static void rec(int k, int value) {
        if (end) {
            return;
        }
        if (k == 8) {
            if (value == 100) {
                for (int i = 1; i <= 7; i++) {
                    sb.append(height[selected[i]]).append('\n');
                }
                end = true;
            }
        } else {
            int start = selected[k - 1] + 1;
            for (int i = start; i <= 9; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                selected[k] = i;
                rec(k + 1, value + height[i]);
                used[i] = false;
                selected[k] = i;
            }
        }
    }
}
