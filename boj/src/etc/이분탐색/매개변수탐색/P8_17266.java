package etc.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P8_17266 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        int l = 0, r = n, ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (determination(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }

    //가로등 위치가 h일 때 굴다리를 모두 비출 수 있는지?
    static boolean determination(int h) {
        int pos = 0;
        for (int i = 1; i <= m; i++) {
            if (a[i] - pos <= h) {
                pos = a[i] + h;
            } else {
                return false;
            }
        }
        return pos >= n;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
