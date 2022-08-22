package etc.투포인터;

import java.util.Scanner;

public class P1_1806 {
    static Scanner sc = new Scanner(System.in);
    static int n, s;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    // 합 s이상 중 최소길이
    static void solve() {
        int r = 0, sum = 0, ans = n + 1;
        for (int l = 1; l <= n; l++) {
            sum -= a[l - 1];

            while (r + 1 <= n && sum < s) {
                r++;
                sum += a[r];
            }

            if (sum >= s) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        if (ans == n + 1) {
            ans = 0;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
