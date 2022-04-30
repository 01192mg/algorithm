package 패캠.투포인터;

import java.util.Scanner;

public class P4_2559 {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        int r = 0, sum = 0, ans = -100 * n;
        for (int l = 1; l + k - 1 <= n; l++) {
            sum -= a[l - 1];

            while (r + 1 <= l + k - 1) {
                r++;
                sum += a[r];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
