package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, E, v1, v2;
    static List<List<Edge>> edges = new ArrayList<>();
    public static final int INF = 200_000_000;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = nextInt();
        E = nextInt();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int from = nextInt();
            int to = nextInt();
            int weight = nextInt();
            edges.get(from).add(new Edge(to, weight));
            edges.get(to).add(new Edge(from, weight));
        }
        v1 = nextInt();
        v2 = nextInt();
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
        int answer = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int answer2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        System.out.println(answer + answer2 >= INF ? -1 : Math.min(answer, answer2));
    }

    private static int dijkstra(int departures, int arrivals) {
        if (departures == arrivals) {
            return 0;
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
        queue.offer(departures);
        distance[departures] = 0;

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
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
                queue.offer(to);
            }
        }
        return distance[arrivals];
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
