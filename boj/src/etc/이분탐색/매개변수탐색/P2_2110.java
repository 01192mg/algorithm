package etc.이분탐색.매개변수탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P2_2110 {
    // c개의 공유기를 설치 했을 때, 가장 인접한 두 공유기의 최대 거리
    // -> 공유기 사이의 거리가 d면, c개의 공유기 설치 가능?
    static int n, c;
    static int[] homes;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        homes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            homes[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(homes, 1, n + 1);
        int l = 0, r = 1000000000, ans = 0;
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

    static boolean determination(int d) {
        int last = homes[1], cnt = 1;
        for (int i = 2; i <= n; i++) {
            if (homes[i] - last >= d) {
                last = homes[i];
                cnt++;
            }
        }
        return cnt >= c;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
