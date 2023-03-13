package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9251 {
    static CustomScanner sc = new CustomScanner();
    static int n, m;
    static char[] sequence1, sequence2;
    static int[][] dp;

    private static void input() {
        sequence1 = sc.next().toCharArray();
        sequence2 = sc.next().toCharArray();
        n = sequence1.length;
        m = sequence2.length;
        dp = new int[n + 1][m + 1];
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sequence1[i - 1] == sequence2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
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

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
    }
}
