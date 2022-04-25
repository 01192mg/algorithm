package 패캠.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P7_9663 {
    static int N, ans;
    static int[] col;

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        col = new int[N + 1];
    }

    private static void recursive(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid check (row, c)
                for (int i = 1; i <= row-1; i++) {
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    recursive(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            return true;
        }
        if (r1 - c1 == r2 - c2) {
            return true;
        }
        if (r1 + c2 == r2 + c2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        input();

        recursive(1);
    }
}
