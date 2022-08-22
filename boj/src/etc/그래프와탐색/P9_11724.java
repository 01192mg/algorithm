package etc.그래프와탐색;

import java.util.Scanner;

public class P9_11724 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int y) {
        visit[y] = true;

        for (int i = 1; i <= n; i++) {
            if (adj[y][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void solve() {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
