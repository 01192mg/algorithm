package etc.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2_1920 {
    static int n,m;
    static int[] a,b;

    static void input() {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
        }
    }

    static void solve() {
        // b가 a에 존재하는지.
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= m; i++) {
            System.out.println(contain(a, 1, n, b[i]));
        }
    }

    private static int contain(int[] a, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == x) {
                return 1;
            } else if (a[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class MyScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
