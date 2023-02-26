package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = nextInt();
        p = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = nextInt();
        }
    }

    static int nextInt() {
        if (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
