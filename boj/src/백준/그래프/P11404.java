package 백준.그래프;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        n = nextInt();
        m = nextInt();
        dist = new int[n + 1][n + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int s = nextInt();
            int e = nextInt();
            int w = nextInt();
            if (dist[s][e] != 0) {
                w = Math.min(w, dist[s][e]);
            }
            dist[s][e] = w;
        }
    }

    static int nextInt() throws IOException {
        if (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static void solve() throws IOException {
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dist[s][k] == INF || dist[k][e] == INF) {
                        continue;
                    }
                    dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }
                bw.append(String.valueOf(dist[i][j])).append(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
