package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[][] prices;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        prices = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                prices[i][j] = sc.nextInt();
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < 3; i++) {
            dp[0][i] = prices[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + prices[i][j];
            }
        }

        int minPrice = Integer.MAX_VALUE;
        for (int price : dp[n - 1]) {
            minPrice = Math.min(minPrice, price);
        }
        System.out.println(minPrice);
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class CustomScanner {
        BufferedReader br;
        StringTokenizer st;

        public CustomScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
