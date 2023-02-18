package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1916 {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int departures, arrivals;
    static List<List<Edge>> adjList = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    private static void solve() {
        distance[departures] = 0;

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
        queue.offer(departures);

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            List<Edge> edges = adjList.get(from);

            if (visited[from]) {
                continue;
            }
            visited[from] = true;

            for (Edge edge : edges) {
                int to = edge.to;

                if (visited[to]) {
                    continue;
                }

                if (distance[from] + edge.weight < distance[to]) {
                    distance[to] = distance[from] + edge.weight;
                    queue.offer(to);
                }
            }
        }
        System.out.println(distance[arrivals]);
    }

    private static void input() {
        N = nextInt();
        M = nextInt();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adjList.get(nextInt()).add(new Edge(nextInt(), nextInt()));
        }
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        visited = new boolean[N + 1];
        departures = nextInt();
        arrivals = nextInt();
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

    public static void main(String[] args) {
        input();
        solve();
    }
}
