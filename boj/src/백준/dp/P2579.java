package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2579 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] scores;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        scores = new int[n + 1];
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            scores[i] = sc.nextInt();
        }
    }

    private static void solve() {
        dp[1][0] = scores[1];
        if (n > 1) {
            dp[2][0] = scores[1] + scores[2];
            dp[2][1] = scores[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i-1][1] + scores[i];
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + scores[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
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
