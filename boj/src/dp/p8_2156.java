package dp;

import java.util.Scanner;

public class p8_2156 {
    static Integer[] dp;
    static int[] inputs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[n + 1];
        inputs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputs[i] = sc.nextInt();
        }

        dp[0] = 0;
        dp[1] = inputs[1];
        if (n > 1) {
            dp[2] = inputs[1] + inputs[2];
        }
        System.out.println(recursive(n));
    }

    private static int recursive(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(recursive(n-2), recursive(n-3) + inputs[n-1]) + inputs[n], recursive(n-1));
        }
        return dp[n];
    }
}
