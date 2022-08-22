package etc.이분탐색.매개변수탐색;

import java.util.Scanner;

public class P5_2343 {
    static int n, m;
    static int[] lectures;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lectures = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lectures[i] = sc.nextInt();
        }
    }

    //m개의 블루레이에 n개의 강의를 넣을 때, 가능한 블루레이 크기 중 최소를 구해라
    //->(블루레이 크기가 x면)이분, (m개의 블루레이에 n개의 강의가 넣어지냐?)결정
    static void solve() {
        int l = 0, r = n * 10000, ans = 0;
        for (int i = 1; i <= n; i++) {
            l = Math.max(l, lectures[i]);
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

    static boolean determination(int size) {
        int sum = 0, count = 1;
        for (int i = 1; i <= n; i++) {
            if (lectures[i] + sum <= size) {
                sum += lectures[i];
            } else {
                count++;
                sum = lectures[i];
            }
        }
        return count <= m;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
