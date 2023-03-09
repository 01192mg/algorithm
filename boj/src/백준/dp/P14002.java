package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14002 {
    static CustomScanner sc = new CustomScanner();
    static int n;
    static int[] sequence;
    static int[] dp;

    private static void input() {
        n = sc.nextInt();
        sequence = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }
    }

    private static void solve() {
        int length = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            length = Math.max(length, dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (length == dp[i]) {
                stack.push(sequence[i]);
                length--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
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
