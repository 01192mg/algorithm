package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1904 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new int[n];
    }

    private static void solve() {
        dp[0] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[n-1]);
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
