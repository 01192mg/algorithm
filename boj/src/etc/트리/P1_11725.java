package etc.트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1_11725 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Integer>[] adj;
    static int[] parent;

    static void input() {
        n = sc.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par) {
                continue;
            }
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void solve() {
        dfs(1, -1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
