package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1562 {
    static CustomScanner sc = new CustomScanner();
    static int MOD = 1_000_000_000;
    static int n;
    static int[][][] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new int[n + 1][10][1 << 10];
    }

    private static void solve() {

        //1~9는 모두 계단 수
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                    } else if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                    } else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i][(1 << 10) - 1]) % MOD;
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
