package etc.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P4_2512 {
    // 주어진 상한액으로 예산 안에서 모든 요청을 처리할 수 있나?
    static int n, m;
    static int[] regions;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        regions = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            regions[i] = sc.nextInt();
        }
        m = sc.nextInt();
    }

    static void solve() {
        int l = 0, r = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            r = Math.max(r, regions[i]);
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (determination(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int limit) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(regions[i], limit);
        }
        return sum <= m;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
