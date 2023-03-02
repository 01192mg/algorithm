package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1495 {
    static CustomScanner sc = new CustomScanner();
    static int n, s, m;
    static int[] volumes;
    static long[][] dp;

    private static void input() {
        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();
        dp = new long[n+1][m+1];
        volumes = new int[n+1];
        for (int i = 1; i <= n; i++) {
            volumes[i] = sc.nextInt();
        }
    }

    private static void solve() {
        dp[0][s] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - volumes[i] >= 0) {
                    dp[i][j - volumes[i]] += dp[i - 1][j];
                }
                if (j + volumes[i] <= m) {
                    dp[i][j + volumes[i]] += dp[i - 1][j];
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i] > 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
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
