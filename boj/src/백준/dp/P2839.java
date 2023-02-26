package 백준.dp;

import java.util.Arrays;
import java.util.Scanner;

public class P2839 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[5001];
        Arrays.fill(dp, -1);
        dp[3] = 1;
        dp[5] = 1;
        int answer = recursive(n);
        if (answer == 0) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static int recursive(int x) {
        if (x < 1 || n < x) {
            return -1;
        }
        if (dp[x] != -1) {
            return dp[x];
        }

        int v1 = recursive(x - 5);
        int v2 = recursive(x - 3);

        if (v1 > 0 && v2 > 0) {
            return dp[x] = Math.min(v1, v2) + 1;
        }
        if (v1 > 0) {
            return dp[x] = v1 + 1;
        }
        if (v2 > 0) {
            return dp[x] = v2 + 1;
        }

        return 0;
    }
}
