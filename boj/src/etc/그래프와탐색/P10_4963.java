package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P10_4963 {
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

    static void bfs(int y, int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        que.add(x);
        visit[y][x] = true;

        while (!que.isEmpty()) {
            y = que.poll();
            x = que.poll();
            for (int i = 0; i < 8; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                    continue;
                }
                if (visit[ny][nx] || adj[ny][nx] == 0) {
                    continue;
                }
                que.add(ny);
                que.add(nx);
                visit[ny][nx] = true;
            }
        }
    }

    static void solve() {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (adj[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
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
