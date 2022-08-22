package etc.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6_14888 {
    static StringBuilder sb = new StringBuilder();
    static int N, min, max;
    static int[] nums, operators;

    public static void main(String[] args) {
        input();
        recursive(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    private static void recursive(int k, int value) {
        if (k == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    recursive(k + 1, calculate(value, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

    private static int calculate(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    private static void input() {
        MyScanner sc = new MyScanner();
        N = sc.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = sc.nextInt();
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
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
