package dp;

import java.util.Scanner;

public class p4_9095 {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp = new Integer[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(recursive(n));
        }
    }

    private static int recursive(int n) {
        if (dp[n] == null) {
            dp[n] = recursive(n-3) + recursive(n - 2) + recursive(n - 1);
        }
        return dp[n];
    }
    //1, 2, 3의 합
    //n = 1 -> 1
    //n = 2 -> 11, 2
    //n = 3 -> 111, 21, 12, 3
    //n = 4 -> 1111, 211, 121, 31, 112, 22, 13

    //n<=4 -> n -> (n-1) + (n-2) + (n-3)
}
