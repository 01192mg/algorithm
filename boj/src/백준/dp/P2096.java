package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2096 {
    public static void main(String[] args) {
        CustomScanner sc = new CustomScanner();
        int n = sc.nextInt();
        // [left/mid/right][min/max]
        int[][] dp = new int[3][2];
        int[] input = new int[3];

        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextInt();
            for (int j = 0; j < 2; j++) {
                dp[i][j] = input[i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                input[j] = sc.nextInt();
            }
            int minLeft = Math.min(dp[0][0], dp[1][0]);
            int minMid = Math.min(minLeft, dp[2][0]);
            int minRight = Math.min(dp[1][0], dp[2][0]);
            dp[0][0] = minLeft + input[0];
            dp[1][0] = minMid + input[1];
            dp[2][0] = minRight + input[2];

            int maxLeft = Math.max(dp[0][1], dp[1][1]);
            int maxMid = Math.max(maxLeft, dp[2][1]);
            int maxRight = Math.max(dp[1][1], dp[2][1]);
            dp[0][1] = maxLeft + input[0];
            dp[1][1] = maxMid + input[1];
            dp[2][1] = maxRight + input[2];
        }
        int max = Math.max(Math.max(dp[0][1], dp[1][1]), dp[2][1]);
        int min = Math.min(Math.min(dp[0][0], dp[1][0]), dp[2][0]);
        System.out.printf(max + " " + min);
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
