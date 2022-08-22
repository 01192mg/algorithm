package etc.그래프와탐색;

import java.util.Scanner;

public class P10_4963dfs {
    static Scanner sc = new Scanner(System.in);
    static int w, h;
    static int[][] adj;
    static boolean[][] visit;
    static int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    static boolean input() {
        w = sc.nextInt();
        h = sc.nextInt();
        if (w == 0 && h == 0) {
            return false;
        }
        adj = new int[h][w];
        visit = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        return true;
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                continue;
            }
            if (visit[ny][nx] || adj[ny][nx] == 0) {
                continue;
            }
            dfs(ny, nx);
        }
    }

    static void solve() {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (adj[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (input()) {
            solve();
        }
    }
}
