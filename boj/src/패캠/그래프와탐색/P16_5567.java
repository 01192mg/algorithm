package 패캠.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P16_5567 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] adj;
    static int[] dist;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new int[n + 1][n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
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
            int a = que.poll();
            for (int b = 1; b <= n; b++) {
                if (adj[a][b] == 1 && dist[b] == -1) {
                    que.add(b);
                    dist[b] = dist[a] + 1;
                }
            }
        }
    }

    static void solve() {
        int ans = 0;
        bfs(1);
        for (int i = 2; i <= n; i++) {
            if (dist[i] == 1 || dist[i] == 2) {
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
