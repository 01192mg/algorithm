package 패캠.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14_18404 {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m, y, x;
    static int[][] dist;
    static int[][] dir = {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, -2}, {2, -1}, {2, 1}, {1, 2},};

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        dist = new int[n + 1][n + 1];
        y = sc.nextInt();
        x = sc.nextInt();
    }

    static void bfs(int y, int x) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        que.add(x);
        dist[y][x] = 0;

        while (!que.isEmpty()) {
            y = que.poll();
            x = que.poll();
            for (int i = 0; i < 8; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 1 || nx < 1 || ny > n || nx > n) {
                    continue;
                }
                if (dist[ny][nx] == -1) {
                    que.add(ny);
                    que.add(nx);
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }
    }

    static void solve() {
        bfs(y, x);
        for (int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            sb.append(dist[y][x]).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
