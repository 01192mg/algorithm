package dp;

import java.util.Scanner;

public class p7_9465 {
    private static final Scanner sc = new Scanner(System.in);
    private static int[][] stickers;
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            initStickers();
            initDp();
            int result = resolve();
            System.out.println(result);
        }
    }

    private static int resolve() {
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
        }
        return Math.max(dp[0][n], dp[1][n]);
    }

    private static void initDp() {
        dp = new int[2][n+1];
        dp[0][1] = stickers[0][1];
        dp[1][1] = stickers[1][1];
    }

    private static void initStickers() {
        stickers = new int[2][n+1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n; j++) {
                stickers[i][j] = sc.nextInt();
            }
        }
    }
}
