package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5557 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] nums;
    static long[][] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new long[n][21];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
    }

    private static void solve() {
        dp[0][nums[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
                if (j + nums[i] <= 20) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 2][nums[n - 1]]);
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
