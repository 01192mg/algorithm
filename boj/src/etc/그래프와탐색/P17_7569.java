package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P17_7569 {
    static Scanner sc = new Scanner(System.in);
    static int h, n, m;
    static int[][][] adj;
    static int[][][] dist;
    static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        adj = new int[h][n][m];
        dist = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    adj[i][j][k] = sc.nextInt();
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dist[i][j][k] = -1;
                    if (adj[i][j][k] == 1) {
                        que.add(new int[]{i, j, k});
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                int nx = cur[2] + dir[i][2];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m) {
                    continue;
                }
                if (adj[nz][ny][nx] == 0 && dist[nz][ny][nx] == -1) {
                    que.add(new int[]{nz, ny, nx});
                    dist[nz][ny][nx] = dist[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }
    }

    static int calcDays() {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (adj[i][j][k] == 0) {
                        if (dist[i][j][k] == -1) {
                            return -1;
                        }
                        ans = Math.max(ans, dist[i][j][k]);
                    }
                }
            }
        }
        return ans;
    }

    static void solve() {
        bfs();
        System.out.println(calcDays());
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
