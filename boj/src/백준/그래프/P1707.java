package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int v, e;
    static List<List<Integer>> graph;
    static int[] color;

    static void input() {
        v = nextInt();
        e = nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int from = nextInt();
            int to = nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        color = new int[v + 1];
    }

    private static int nextInt() {
        if (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return Integer.parseInt(st.nextToken());
    }

    static void solve() {
        for (int i = 1; i <= v; i++) {
            if (color[i] != 0) {
                continue;
            }
            if (isBipartite(i)) {
                continue;
            }
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }

    private static boolean isBipartite(Integer start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            for (Integer to : graph.get(from)) {
                if (color[from] == color[to]) {
                    return false;
                }
                if (color[to] == 0) {
                    color[to] = color[from] * -1;
                    queue.offer(to);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int k = nextInt();
        for (int i = 0; i < k; i++) {
            input();
            solve();
        }
    }
}
