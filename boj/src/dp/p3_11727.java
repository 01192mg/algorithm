package dp;

import java.util.Scanner;

public class p3_11727 {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[1001];
        dp[1] = 1;
        dp[2] = 3;
        System.out.println(recursive(n));
    }

    private static int recursive(int n) {
        if (dp[n] == null) {
            dp[n] = (2 * recursive(n - 2) + recursive(n - 1)) % 10007;
        }
        return dp[n];
    }
}
