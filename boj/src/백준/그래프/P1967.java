package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, farthestFromRoot, length;
    static List<List<Node>> adj = new ArrayList<>();
    static boolean[] visited;

    private static void input() {
        n = nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int from = nextInt();
            int to = nextInt();
            int weight = nextInt();
            adj.get(from).add(new Node(to, weight));
            adj.get(to).add(new Node(from, weight));
        }
    }

    private static int nextInt() {
        if (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(farthestFromRoot, 0);
        System.out.println(length);
    }

    private static void dfs(int from, int distance) {
        if (visited[from]) {
            return;
        }
        visited[from] = true;
        if (distance > length) {
            farthestFromRoot = from;
            length = distance;
        }
        for (Node node : adj.get(from)) {
            dfs(node.to, distance + node.weight);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
