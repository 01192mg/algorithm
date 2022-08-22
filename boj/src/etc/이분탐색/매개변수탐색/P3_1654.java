package etc.이분탐색.매개변수탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P3_1654 {
    // 랜선의 길이가 len 일 때 k개를 만들 수 있는지.
    static int k, n;
    static int[] lanCables;

    static void input() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        lanCables = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            lanCables[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(lanCables, 1, k + 1);
        long l = 1, r = Integer.MAX_VALUE, ans = 0;
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

    static boolean determination(int cableLength) {
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count += lanCables[i] / cableLength;
        }
        return count >= n;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
