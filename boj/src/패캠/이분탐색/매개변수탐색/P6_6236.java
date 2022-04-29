package 패캠.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P6_6236 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] amounts;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        amounts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            amounts[i] = sc.nextInt();
        }
    }

    // n일 동안 m번만 통장에서 돈을 뺌, 인출 단위 k의 최솟값
    // 돈이 부족하면 남은 금액 통장에 넣고 다시 k원 인출
    // m번을 맞추기 위해 돈이 안부족해도 남은 금액 통장에 집어넣고 k원 인출 가능
    // 즉 m번 보다 작아도 됨
    // 인출 단위 k가 주어졌을 때, 인출 횟수 m번 안에 모든 amounts 해결 가능?
    static void solve() {
        int l = 1, r = n * 10000, ans = 0;
        for (int i = 1; i <= n; i++) {
            l = Math.max(l, amounts[i]);
        }
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

    static boolean determination(int k) {
        int sum = 0, count = 1;
        for (int i = 1; i <= n; i++) {
            if (sum + amounts[i] > k) {
                count++;
                sum = amounts[i];
            } else {
                sum += amounts[i];
            }
        }
        return count <= m;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
