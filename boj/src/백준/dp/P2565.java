package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2565 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static List<UtilityPole> poles = new ArrayList<>();
    static int[] dp;

    private static void input() {
        n = sc.nextInt();
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            poles.add(new UtilityPole(sc.nextInt(), sc.nextInt()));
        }
    }

    private static void solve() {
        int length = 0;
        Collections.sort(poles);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (poles.get(j).to < poles.get(i).to) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            length = Math.max(length, dp[i]);
        }
        System.out.println(n - length);
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class UtilityPole implements Comparable<UtilityPole> {
        int from;
        int to;

        public UtilityPole(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(UtilityPole o) {
            return this.from - o.from;
        }
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
