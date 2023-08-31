package 백준.dp;

import java.util.Scanner;

public class P1958 {
    private static final Scanner sc = new Scanner(System.in);
    static String str1, str2, str3;
    static int l, m, n;
    static int[][][] map;

    private static void input() {
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        str3 = sc.nextLine();
        l = str1.length();
        m = str2.length();
        n = str3.length();
        map = new int[l + 1][m + 1][n + 1];
    }

    private static void solve() {
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        map[i][j][k] = map[i - 1][j - 1][k - 1] + 1;
                    } else {
                        map[i][j][k] = Math.max(
                                Math.max(Math.max(map[i - 1][j][k], map[i][j - 1][k]), map[i][j][k - 1]),
                                Math.max(Math.max(map[i - 1][j - 1][k], map[i][j - 1][k - 1]), map[i - 1][j][k - 1])
                        );
                    }
                }
            }
        }
        System.out.println(map[l][m][n]);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
