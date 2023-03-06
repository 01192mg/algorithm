package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[][] input;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        input = new int[n + 2][n + 2];
        dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                input[i][j] = sc.nextInt();
            }
        }
    }

    private static void solve() {
        dp[1][1] = input[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + input[i][j];
            }
        }

        int longestPath = 0;
        for (int path : dp[n]) {
            longestPath = Math.max(longestPath, path);
        }
        System.out.println(longestPath);
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
