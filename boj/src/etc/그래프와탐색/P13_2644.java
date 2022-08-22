package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13_2644 {
    static Scanner sc = new Scanner(System.in);
    static int n, m, s, e;
    static int[][] adj;
    static int[] dist;

    static void input() {
        n = sc.nextInt();
        s = sc.nextInt();
        e = sc.nextInt();
        m = sc.nextInt();
        adj = new int[n + 1][n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            adj[y][x] = 1;
            adj[x][y] = 1;
        }
    }

    static void bfs(int start) {
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;
        while (!que.isEmpty()) {
            int y = que.poll();
            for (int x = 1; x <= n; x++) {
                if (adj[y][x] == 1 && dist[x] == -1) {
                    que.add(x);
                    dist[x] = dist[y] + 1;
                }
            }
        }
    }

    static void solve() {
        bfs(s);
        System.out.println(dist[e]);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
