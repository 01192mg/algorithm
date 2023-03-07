package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
    static CustomScanner sc = new CustomScanner();
    static int n, k;
    static int[][] stuff;
    static int[][] dp;

    private static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        stuff = new int[n+1][2];
        dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                stuff[i][j] = sc.nextInt();
            }
        }
    }

    private static void solve() {
        //dp[n][weight] = value
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - stuff[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuff[i][0]] + stuff[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= k; i++) {
            answer = Math.max(answer, dp[n][i]);
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
