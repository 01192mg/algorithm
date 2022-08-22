package etc.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P5_15970 {
    static int n;
    static int ans;
    static ArrayList<Integer>[] a;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int coor, color;
            coor = sc.nextInt();
            color = sc.nextInt();
            a[color].add(coor);
        }
    }

    private static void solve() {
        for (int color = 1; color <= n; color++) {
            Collections.sort(a[color]);
            for (int i = 0; i < a[color].size(); i++) {
                ans += Math.min(toLeft(color, i), toRight(color, i));
            }
        }
    }

    private static int toLeft(int color, int i) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(i) - a[color].get(i - 1);
    }

    private static int toRight(int color, int i) {
        if (i == a[color].size() - 1) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(i + 1) - a[color].get(i);
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(ans);
    }
}
