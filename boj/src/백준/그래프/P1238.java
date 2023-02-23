package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, x;
    static List<List<Edge>> edges = new ArrayList<>();
    static List<List<Edge>> reversedEdges = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        n = nextInt();
        m = nextInt();
        x = nextInt();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
            reversedEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt();
            int to = nextInt();
            int weight = nextInt();
            edges.get(from).add(new Edge(to, weight));
            reversedEdges.get(to).add(new Edge(from, weight));
        }
        answer = new int[n + 1];
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
        dijkstra(x);
        edges = reversedEdges;
        dijkstra(x);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]);
        }
        System.out.println(max);
    }

    private static void dijkstra(int from) {
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(v -> distance[v]));
        queue.offer(from);
        distance[from] = 0;

        while (!queue.isEmpty()) {
            from = queue.poll();
            if (visited[from]) {
                continue;
            }
            visited[from] = true;
            for (Edge edge : edges.get(from)) {
                int to = edge.to;
                int weight = edge.weight;
                if (visited[to] || distance[to] <= distance[from] + weight) {
                    continue;
                }
                distance[to] = distance[from] + weight;
                queue.add(to);
            }
        }

        for (int i = 1; i <= n; i++) {
            answer[i] += distance[i];
        }
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
