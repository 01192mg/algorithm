package 패캠.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5_2178 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static String[] a;
    static int[][] dis;
    static boolean[][] visit;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }
        visit = new boolean[n][m];
        dis = new int[n][m];
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(0); // y
        que.add(0); // x
        visit[0][0] = true;
        dis[0][0] = 1;
        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visit[ny][nx]) {
                    continue;
                }
                if (a[ny].charAt(nx) == '0') {
                    continue;
                }
                que.add(ny);
                que.add(nx);
                visit[ny][nx] = true;
                dis[ny][nx] = dis[y][x] + 1;
            }
        }
    }

    static void solve() {
        bfs();
        System.out.println(dis[n - 1][m - 1]);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
