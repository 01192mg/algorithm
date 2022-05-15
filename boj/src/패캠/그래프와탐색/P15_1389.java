package 패캠.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P15_1389 {
    static Scanner sc = new Scanner(System.in);
    static int n, m, min, ans;
    static int[][] adj;
    static int[] dist;

    static void input() {
        n = sc.nextInt();
        adj = new int[n + 1][n + 1];
        dist = new int[n + 1];
        m = sc.nextInt();
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
                if (adj[y][x] != 1 || dist[x] != -1) {
                    continue;
                }
                que.add(x);
                dist[x] = dist[y] + 1;
            }
        }
    }

    static void solve() {
        min = Integer.MAX_VALUE;
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            bfs(start);
            for (int i = 1; i <= n; i++) {
                sum += dist[i];
            }
            if (sum < min) {
                min = sum;
                ans = start;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
