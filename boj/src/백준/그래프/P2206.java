package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N, M;
    static int[][] map;
    static int[][][] adj;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        N = nextInt();
        M = nextInt();
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 1; j <= row.length; j++) {
                map[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        adj = new int[N+1][M+1][2];
        visit = new boolean[N+1][M+1][2];
    }

    private static int nextInt() throws IOException {
        if (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        bfs();
        int result = -1;
        if (adj[N][M][0] != 0 || adj[N][M][1] != 0) {
            if (adj[N][M][0] == 0) {
                result = adj[N][M][1];
            } else if (adj[N][M][1] == 0) {
                result = adj[N][M][0];
            } else {
                result = Math.min(adj[N][M][0], adj[N][M][1]);
            }
        }
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(new Vertex(1, 1, 0));
        queue.add(new Vertex(1, 1, 1));
        adj[1][1][0] = 1;
        adj[1][1][1] = 1;
        visit[1][1][0] = true;
        visit[1][1][1] = true;

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            int y = v.y;
            int x = v.x;
            int c = v.c;

            for (int[] dir : DIRECTION) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny < 1 || ny > N || nx < 1 || nx > M || visit[ny][nx][c]) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    adj[ny][nx][c] = adj[y][x][c] + 1;
                    queue.offer(new Vertex(ny, nx, c));
                    visit[ny][nx][c] = true;
                } else if (map[ny][nx] == 1 && c == 0) {
                    adj[ny][nx][1] = adj[y][x][0] + 1;
                    queue.offer(new Vertex(ny, nx, 1));
                }
            }
        }
    }

    private static class Vertex {
        int y;
        int x;
        int c;

        public Vertex(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
}
