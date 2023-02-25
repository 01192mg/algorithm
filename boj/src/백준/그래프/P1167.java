package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1167 {
    static CustomScanner sc = new CustomScanner();
    static int v;
    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visited;

    private static void input() {
        v = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            int from = sc.nextInt();
            while (true) {
                int to = sc.nextInt();
                if (to == -1) {
                    break;
                }
                int weight = sc.nextInt();
                nodes.get(from).add(new Node(to, weight));
            }
        }
    }

    static int farthestNode, length;
    private static void solve() {
        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(farthestNode, 0);
        System.out.println(length);
    }

    private static void dfs(int from, int distance) {
        if (visited[from]) {
            return;
        }
        visited[from] = true;
        if (length < distance) {
            length = distance;
            farthestNode = from;
        }
        for (Node node : nodes.get(from)) {
            dfs(node.to, node.weight + distance);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class CustomScanner {
        BufferedReader br;
        StringTokenizer st;

        public CustomScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
