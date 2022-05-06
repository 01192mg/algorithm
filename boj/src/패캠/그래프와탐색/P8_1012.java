package 패캠.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P8_1012 {
    static Scanner sc = new Scanner(System.in);
    static int t, n, m, k;
    static int[][] adj;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        adj = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[y][x] = 1;
        }
        visit = new boolean[n][m];
    }

    static void bfs(int y, int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        que.add(x);
        visit[y][x] = true;
        while (!que.isEmpty()) {
            y = que.poll();
            x = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
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
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (adj[y][x] == 1 && !visit[y][x]) {
                    bfs(y, x);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }
}
