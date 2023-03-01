package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1309 {
    static CustomScanner sc = new CustomScanner();
    static int MOD = 9901;
    static int n;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new int[n][3];
    }

    private static void solve() {
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[n - 1][i];
        }
        answer %= MOD;
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
