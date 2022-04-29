package 패캠.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P1_2805 {
    static int n, m;
    static int[] heights;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        heights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heights[i] = sc.nextInt();
        }
    }

    static void solve() {
        long l = 0, r = 2000000000, ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (determination((int) mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    // h로 잘랐을 때 나무 길이의 합이 m 이상인지?
    static boolean determination(int h) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (heights[i] > h) {
                sum += heights[i] - h;
            }
        }
        return sum >= m;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
