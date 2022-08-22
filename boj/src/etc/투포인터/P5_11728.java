package etc.투포인터;

import java.util.Scanner;

public class P5_11728 {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] a, b;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1];
        b = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
        }
    }

    static void solve() {
        int l = 1, r = 1;
        while (l <= n && r <= m) {
            if (a[l] <= b[r]) {
                sb.append(a[l]).append(' ');
                l++;
            } else {
                sb.append(b[r]).append(' ');
                r++;
            }
        }
        while (l <= n) {
            sb.append(a[l]).append(' ');
            l++;
        }
        while (r <= m) {
            sb.append(b[r]).append(' ');
            r++;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
