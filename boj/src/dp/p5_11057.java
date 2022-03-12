package dp;

import java.util.Scanner;

public class p5_11057 {
    static Integer[][] dp;
    static int n;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        initDp();
        for (int value = 0; value < 10; value++) {
            result += recursive(n, value);
        }
        System.out.println(result % 10007);
    }

    private static void initDp() {
        dp = new Integer[n + 1][10];
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
    }

    private static int recursive(int digit, int value) {
        if (digit == 1) {
            return dp[digit][value];
        }
        if (dp[digit][value] == null) {
            dp[digit][value] = 0;
            for (int i = 0; i <= value; i++) {
                dp[digit][value] += recursive(digit-1, i);
            }
            dp[digit][value] %= 10007;
        }
        return dp[digit][value];
    }
}