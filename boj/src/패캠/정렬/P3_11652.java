package 패캠.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3_11652 {
    private static final MyScanner sc = new MyScanner();
    private static int n;
    private static long[] values;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void input() {
        n = sc.nextInt();
        values = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextLong();
        }
    }

    private static void pro() {
        Arrays.sort(values);

        long mode = values[0];
        int modeCount = 1;
        int currentCount = 1;

        for (int i = 1; i < n; i++) {
            if (values[i - 1] == values[i]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (modeCount < currentCount) {
                modeCount = currentCount;
                mode = values[i];
            }
        }
        System.out.println(mode);
    }

    private static class MyScanner {
        private static BufferedReader br;
        private static StringTokenizer st;

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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
