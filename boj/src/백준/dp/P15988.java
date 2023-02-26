package 백준.dp;

import java.util.Scanner;

public class P15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] inputs = new int[t];

        int max = 0;
        for (int i = 0; i < t; i++) {
            int input = sc.nextInt();
            max = Math.max(max, input);
            inputs[i] = input;
        }

        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        for (int input : inputs) {
            System.out.println(dp[input]);
        }
    }
}
