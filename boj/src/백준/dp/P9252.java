package 백준.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P9252 {
    static final Scanner sc = new Scanner(System.in);
    static int n, m;
    static String str1, str2;

    static int[][] map;

    private static void input() {
        str1 = sc.next();
        str2 = sc.next();
        n = str1.length();
        m = str2.length();
        map = new int[str1.length() + 1][str2.length() + 1];
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        System.out.println(map[n][m]);

        Deque<Character> stack = new ArrayDeque<>();
        while (map[n][m] != 0) {
            if (map[n][m] == map[n - 1][m]) {
                n--;
            } else if (map[n][m] == map[n][m - 1]) {
                m--;
            } else {
                stack.push(str1.charAt(n - 1));
                n--;
                m--;
            }
        }
        stack.forEach(System.out::print);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
