package etc.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6_2470 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] a;

    static void input() {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int min = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= n - 1; left++) {
            int res = lowerBound(a, left + 1, n, -a[left]);
            if (left + 1 <= res - 1 && res - 1 <= n && Math.abs(a[res - 1] + a[left]) < min) {
                min = Math.abs(a[res - 1] + a[left]);
                v1 = a[left];
                v2 = a[res - 1];
            }
            if (left + 1 <= res && res <= n && Math.abs(a[res] + a[left]) < min) {
                min = Math.abs(a[res] + a[left]);
                v1 = a[left];
                v2 = a[res];
            }
        }
        sb.append(v1).append(' ').append(v2);
    }

    static int lowerBound(int[] a, int l, int r, int x) {
        int res = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] >= x) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb);
    }

    static class MyScanner {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

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
