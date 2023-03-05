package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] sequence;
    static int[] dp;

    private static void input() {
        n = sc.nextInt();
        sequence = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sequence[i] = sc.nextInt();
        }
    }

    private static void solve() {
        int answer = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
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
