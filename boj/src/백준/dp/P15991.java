package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] inputs = new int[t];
        int max = 0;
        long[] dp;

        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            inputs[i] = input;
            max = Math.max(max, input);
        }

        dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for (int i = 7; i <= max; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009;
        }

        for (int input : inputs) {
            System.out.println(dp[input]);
        }
    }
}
