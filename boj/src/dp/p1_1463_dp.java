package dp;

import java.util.Scanner;

public class p1_1463_dp {
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        dp = new Integer[x + 1];
        int result = dp(x);
        System.out.println(result);
    }

    private static int dp(int x) {
        if (x == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if (dp[x] == null) {
            if (x % 3 == 0) {
                min = dp(x / 3);
            }
            if (x % 2 == 0) {
                int tmp = dp(x / 2);
                min = Math.min(min, tmp);
            }
            int tmp = dp(x - 1);
            min = Math.min(min, tmp);
            dp[x] = min + 1;
        }
        return dp[x];
    }
}
