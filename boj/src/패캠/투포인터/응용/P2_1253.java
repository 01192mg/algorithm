package 패캠.투포인터.응용;

import java.util.Arrays;
import java.util.Scanner;

public class P2_1253 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (twoPointers(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean twoPointers(int x) {
        int l = 1, r = n;
        int target = a[x];
        while (l < r) {
            if (l == x) {
                l++;
            } else if (r == x) {
                r--;
            } else {
                if (a[l] + a[r] == target) {
                    return true;
                } else if (a[l] + a[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
