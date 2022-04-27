package 패캠.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class p5_10816 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] a, b;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= m; i++) {
            int x = b[i];
            int upper = upperBound(a, 1, n, x);
            int lower = lowerBound(a, 1, n, x);
            sb.append(upper - lower).append(' ');
        }
    }

    private static int lowerBound(int[] a, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] a, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb);
    }
}
