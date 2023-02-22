package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    static int[] parent;

    private static void input() {
        N = nextInt();
        M = nextInt();

        for (int i = 0; i < M; i++) {
            int from = nextInt();
            int to = nextInt();
            int weight = nextInt();
            if (from == to) {
                continue;
            }
            queue.add(new Edge(from, to, weight));
        }
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
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
        int distance = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int fromParent = find(edge.from);
            int toParent = find(edge.to);
            if (fromParent == toParent) {
                continue;
            }
            union(fromParent, toParent);
            distance += edge.weight;
        }
        System.out.println(distance);
    }

    private static int find(int vertex) {
        if (vertex == parent[vertex]) {
            return vertex;
        }
        return parent[vertex] = find(parent[vertex]);
    }

    private static void union(int fromParent, int toParent) {
        if (fromParent < toParent) {
            parent[toParent] = fromParent;
            return;
        }
        parent[fromParent] = toParent;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
