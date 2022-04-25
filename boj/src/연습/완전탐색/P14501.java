package 연습.완전탐색;

import java.util.Scanner;

public class P14501 {
    private static int n, ans;
    private static int[] t, p;

    public static void main(String[] args) {
        input();
        rec(1, 0);
        System.out.println(ans);
    }

    private static void rec(int k, int value) {
        if (k == n + 1) {
            ans = Math.max(ans, value);
        } else {
            if (k + t[k] - 1 <= n) {
                rec(k + t[k], value + p[k]);
            }
            rec(k + 1, value);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        ans = Integer.MIN_VALUE;
    }
}
