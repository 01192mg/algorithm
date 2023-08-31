package etc.그래프와탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
    static int n, m, v;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    private static void input() {
        n = nextInt();
        m = nextInt();
        v = nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt();
            int to = nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
    }

    private static void solve() throws IOException {
        visited = new boolean[n + 1];
        dfs(v);
        bw.write("\n");
        visited = new boolean[n + 1];
        bfs(v);
        bw.flush();
        bw.close();
    }

    private static void dfs(int y) throws IOException {
        if (visited[y]) {
            return;
        }
        visited[y] = true;
        bw.write(y + " ");
        for (int ny : graph.get(y)) {
            dfs(ny);
        }
    }

    private static void bfs(int y) throws IOException {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(y);
        visited[y] = true;
        while (!que.isEmpty()) {
            y = que.poll();
            bw.write(y + " ");
            for (int ny : graph.get(y)) {
                if (!visited[ny]) {
                    que.offer(ny);
                    visited[ny] = true;
                }
            }
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

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
