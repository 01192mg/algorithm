package 패캠.투포인터.응용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1_13144 {
    static MyScanner sc = new MyScanner();
    static int n;
    static int[] a, cnt;

    static void input() {
        n = sc.nextInt();
        a = new int[n + 1];
        cnt = new int[100000 + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solve() {
        long ans = 0;
        int r = 0;
        for (int l = 1; l <= n; l++) {
            while (r + 1 <= n && cnt[a[r + 1]] == 0) {
                r++;
                cnt[a[r]]++;
            }
            ans += r - l + 1;
            cnt[a[l]]--;
        }
        System.out.println(ans);
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
