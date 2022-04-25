package 패캠.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5_15654 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;
    static int[] nums;
    static boolean[] used;

    public static void main(String[] args) {
        input();
        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (used[i]) {
                    continue;
                }
                selected[k] = nums[i];
                used[i] = true;
                recursive(k + 1);
                selected[k] = 0;
                used[i] = false;
            }
        }
    }

    private static void input() {
        MyScanner sc = new MyScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        used = new boolean[N + 1];
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        selected = new int[M + 1];
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
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
