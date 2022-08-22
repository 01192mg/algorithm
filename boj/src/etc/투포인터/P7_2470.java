package etc.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7_2470 {
    static StringBuilder sb = new StringBuilder();
    static MyScanner sc = new MyScanner();
    static int n;
    static int[] a;

    static void input() {
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int l = 1, r = n, v1 = 0, v2 = 0, sum = Integer.MAX_VALUE;
        while (l < r) {
            int tmp = a[l] + a[r];
            if (Math.abs(tmp) < sum) {
                sum = Math.abs(tmp);
                v1 = a[l];
                v2 = a[r];
            }
            if (tmp < 0) {
                l++;
            } else {
                r--;
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class MyScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
