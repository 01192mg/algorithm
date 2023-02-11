package 백준.etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1780 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n;
    private static int[][] map;
    private static int[] count = {0, 0, 0};

    private static void input() {
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt() + 1;
            }
        }
    }

    private static void solve(int y, int x, int size) {
        if (size == 1) {
            count[map[y][x]]++;
            return;
        }

        Set<Integer> nums = new HashSet();
        nums.add(map[y][x]);
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (nums.add(map[i][j])) {
                    break;
                }
            }
        }

        if (nums.size() == 1) {
            count[map[y][x]]++;
            return;
        }

        int nextSize = size / 3;
        solve(y, x, nextSize);
        solve(y, x + nextSize, nextSize);
        solve(y, x + (2 * nextSize), nextSize);

        solve(y + nextSize, x, nextSize);
        solve(y + nextSize, x + nextSize, nextSize);
        solve(y + nextSize, x + (2 * nextSize), nextSize);

        solve(y + (2 * nextSize), x, nextSize);
        solve(y + (2 * nextSize), x + nextSize, nextSize);
        solve(y + (2 * nextSize), x + (2 * nextSize), nextSize);
    }

    public static void main(String[] args) {
        input();
        solve(0, 0, n);
        for (int c : count) {
            System.out.println(c);
        }
    }
}
