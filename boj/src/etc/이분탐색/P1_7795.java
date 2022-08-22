package etc.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1_7795 {
    static final MyScanner sc = new MyScanner();
    static int t, n, m;
    static int[] a, b;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1];
        b = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextInt();
        }
    }

    private static void solve() {
        Arrays.sort(b, 1, m + 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += lowerBound(b, 1, m, a[i]);
        }
        System.out.println(ans);
    }

    private static int lowerBound(int[] b, int l, int r, int x) {
        // b[l...r] 에서 x 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 탐색 실패 시 l-1 을 return 한다.
        int res = l - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (b[mid] < x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }

    static class MyScanner {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
