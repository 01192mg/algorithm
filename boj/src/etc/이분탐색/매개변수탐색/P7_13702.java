package etc.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P7_13702 {
    // k명에게 최대한 많은 양의 막걸리를 분배할 수 있는 용량은?
    // 용량이 x일 때 k명에게 분배 가능한지?
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
        long l = 1, r = Integer.MAX_VALUE, ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (determination(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(long amount) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += a[i] / amount;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
