package etc.투포인터;

import java.util.Scanner;

public class P2_2003 {
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
        int r = 0, sum = 0, ans = 0;
        for (int l = 1; l <= n; l++) {
            sum -= a[l - 1];
            while (r + 1 <= n && sum < m) {
                r++;
                sum += a[r];
            }
            if (sum == m) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
