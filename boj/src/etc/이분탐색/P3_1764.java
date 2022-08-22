package etc.이분탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P3_1764 {
    static int n, m, ans;
    static String[] a, b;
    static List<String> names = new ArrayList<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        a = new String[n + 1];
        b = new String[m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLine();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextLine();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        Arrays.sort(b, 1, m + 1);
        for (int i = 1; i <= m; i++) {
            if (contains(a, 1, n, b[i])) {
                ans++;
                names.add(b[i]);
            }
        }
    }

    static boolean contains(String[] a, int l, int r, String x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int compare = a[mid].compareTo(x);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    static void output() {
        System.out.println(ans);
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
