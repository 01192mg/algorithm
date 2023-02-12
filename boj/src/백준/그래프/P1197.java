package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
    static int[] parent;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        V = nextInt();
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        E = nextInt();
        for (int i = 0; i < E; i++) {
            edges.offer(new Edge(nextInt(), nextInt(), nextInt()));
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
        int result = 0;
        int count = 1;
        while (count < V) {
            Edge edge = edges.poll();
            if (union(edge.start, edge.end)) {
                result += edge.weight;
                count++;
            }
        }
        System.out.println(result);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2) {
            return false;
        }
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
        return true;
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
