package etc.그래프와탐색;

import java.util.*;

public class P1_1260 {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int n, m, v;
    static List<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }
    }

    static void solve() {
        visit = new boolean[n + 1];
        dfs(v);
        sb.append('\n');
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int y) {
        sb.append(y).append(' ');
        visit[y] = true;
        for (int x : adj[y]) {
            if (visit[x]) {
                continue;
            }
            dfs(x);
        }
    }

    private static void bfs(int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        visit[y] = true;
        while (!que.isEmpty()) {
            y = que.poll();
            sb.append(y).append(' ');
            for (int x : adj[y]) {
                if (visit[x]) {
                    continue;
                }
                que.add(x);
                visit[x] = true;
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
