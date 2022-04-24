package 패캠.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3_15652 {
    //중복 허용해서 m개 고르기
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) {
        input();
        recursive(1);
        System.out.println(sb.toString());

    }

    private static void input() {
        MyScanner sc = new MyScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
    }

    private static void recursive(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = selected[k - 1];
            if (start == 0) {
                start = 1;
            }
            for (int candidate = start; candidate <= N; candidate++) {
                selected[k] = candidate;
                recursive(k + 1);
                selected[k] = 0;
            }
        }
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
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
