package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12_7562 {
    static Scanner sc = new Scanner(System.in);
    static int l, y1, x1, y2, x2;
    static int[][] dist;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    static void input() {
        l = sc.nextInt();
        dist = new int[l][l];
        y1 = sc.nextInt();
        x1 = sc.nextInt();
        y2 = sc.nextInt();
        x2 = sc.nextInt();
    }

    static void bfs(int y, int x) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
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

                if (ny < 0 || nx < 0 || ny >= l || nx >= l) {
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
        bfs(y1, x1);
        System.out.println(dist[y2][x2]);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }
}
