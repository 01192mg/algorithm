package etc.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_1182 {
    private static int n, s, ans;
    private static int[] nums;

    public static void main(String[] args) {
        input();
        rec(1, 0);
        if (s == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    private static void input() {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        s = sc.nextInt();
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
    }

    private static void rec(int k, int value) {
        if (k == n + 1) {
            if (value == s) {
                ans++;
            }
        } else {
            // include
            rec(k + 1, value + nums[k]);
            // exclude
            rec(k + 1, value);
        }
    }

    private static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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
