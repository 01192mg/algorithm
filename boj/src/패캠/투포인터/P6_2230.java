package 패캠.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class P6_2230 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int l = 1, r = 1, ans = Integer.MAX_VALUE;
        while (l <= n && r <= n) {
            if (a[r] - a[l] >= m) {
                ans = Math.min(ans, a[r] - a[l]);
                l++;
            } else {
                r++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
