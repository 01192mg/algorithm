package 백준.삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13458 {
    static final CustomScanner sc = new CustomScanner();
    static int n, b, c;
    static long answer;
    static int[] testTakers;

    private static void input() {
        n = sc.nextInt();
        testTakers = new int[n];
        for (int i = 0; i < n; i++) {
            testTakers[i] = sc.nextInt();
        }
        b = sc.nextInt();
        c = sc.nextInt();
    }

    private static void solve() {
        for (int testTaker : testTakers) {
            answer += getSupervisor(testTaker);
        }
        System.out.println(answer);
    }

    private static int getSupervisor(int testTaker) {
        if (testTaker <= b) {
            return 1;
        }
        testTaker -= b;
        return testTaker % c != 0 ? testTaker / c + 2 : testTaker / c + 1;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class CustomScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public int nextInt() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
