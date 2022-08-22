package etc.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P4_3273 {
    static int n, x;
    static int[] a;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        x = sc.nextInt();
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int ans = 0;
        for (int l = 1; l <= n - 1; l++) {
            if (biSearch(a, l + 1, n, x - a[l])) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean biSearch(int[] a, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > x) {
                r = mid - 1;
            } else if (a[mid] < x) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
