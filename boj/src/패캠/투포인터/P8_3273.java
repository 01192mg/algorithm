package 패캠.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class P8_3273 {
    static int n, x, ans;
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
        Arrays.sort(a, 1, n+1);
        int l = 1;
        int r = n;
        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == x) {
                ans++;
                l++;
                r--;
            } else if (sum < x) {
                l++;
            } else {
                r--;
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(ans);
    }
}
