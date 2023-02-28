package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10844 {
    static CustomScanner sc = new CustomScanner();
    static final int MOD = 1_000_000_000;
    static int n;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new int[n + 1][10];
    }

    private static void solve() {
        //N인 계단 수
        // d[n][3] = d[n-1][2] + d[n-1][4]
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
                dp[i][j] %= MOD;
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
            answer %= MOD;
        }
        System.out.println(answer);
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
