package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] novels;
    static int[] sum;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        novels = new int[n + 1];
        sum = new int[n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            novels[i] = sc.nextInt();
        }
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + novels[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] += sum[j] - sum[i - 1];
            }
        }
        System.out.println(dp[1][n]);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
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
