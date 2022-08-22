package etc.그래프와탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P11_2606 {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static List<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            adj[y].add(x);
            adj[x].add(y);
        }
    }

    private static void bfs(int y) {
        visit[y] = true;
        ans++;
        for (int x : adj[y]) {
            if (visit[x]) {
                continue;
            }
            bfs(x);
        }
    }

    static void solve() {
        bfs(1);
        System.out.println(--ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
