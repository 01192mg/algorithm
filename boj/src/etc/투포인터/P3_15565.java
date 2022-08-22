package etc.투포인터;

import java.util.Scanner;

public class P3_15565 {
    //라이언 3개 포함 된 가장 짧은 집합
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
        int r = 0, cnt = 0, ans = n + 1;
        for (int l = 1; l <= n; l++) {
            if (a[l - 1] == 1) {
                cnt--;
            }
            while (r + 1 <= n && cnt < k) {
                r++;
                if (a[r] == 1) {
                    cnt++;
                }
            }
            if (cnt == k) {
                ans = Math.min(ans, r - l + 1);
            }
        }

        if (ans == n + 1) {
            ans = -1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
