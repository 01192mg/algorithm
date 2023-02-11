package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int v, e, s;
    private static List<List<Node>> gragh = new ArrayList<>();
    private static int[] distance;

    private static void input() throws IOException {
        v = nextInt();
        e = nextInt();
        s = nextInt();
        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= v; i++) {
            gragh.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            gragh.get(nextInt()).add(new Node(nextInt(), nextInt()));
        }
    }

    private static int nextInt() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        dijkstra();

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(d -> d.d));
        queue.offer(new Vertex(s, 0));
        distance[s] = 0;

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (vertex.d != distance[vertex.i]) {
                continue;
            }
            for (Node node : gragh.get(vertex.i)) {
                if (distance[node.n] <= distance[vertex.i] + node.w) {
                    continue;
                }
                distance[node.n] = distance[vertex.i] + node.w;
                queue.add(new Vertex(node.n, distance[node.n]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    static class Vertex {
        int i;
        int d;

        public Vertex(int i, int d) {
            this.i = i;
            this.d = d;
        }
    }
}
