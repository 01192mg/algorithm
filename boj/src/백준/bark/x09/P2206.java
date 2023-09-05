package 백준.bark.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int n, m;
    static char[][] map;
    static int[][][] adj;

    private static void input() {
        n = nextInt();
        m = nextInt();
        map = new char[n][m];
        adj = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            map[i] = next().toCharArray();
            for (int j = 0; j < m; j++) {
                adj[i][j][0] = -1;
                adj[i][j][1] = -1;
            }
        }
    }

    private static void solve() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        que.offer(0);
        que.offer(0);
        adj[0][0][0] = 1;
        while (!que.isEmpty()) {
            Integer y = que.poll();
            Integer x = que.poll();
            Integer z = que.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || adj[ny][nx][z] != -1) {
                    continue;
                }
                if (map[ny][nx] == '0') {
                    adj[ny][nx][z] = adj[y][x][z] + 1;
                    que.offer(ny);
                    que.offer(nx);
                    que.offer(z);
                } else if (map[ny][nx] == '1' && z == 0) {
                    adj[ny][nx][1] = adj[y][x][0] + 1;
                    que.offer(ny);
                    que.offer(nx);
                    que.offer(1);
                }
            }
        }
        if (adj[n - 1][m - 1][0] != -1 && adj[n - 1][m - 1][1] != -1) {
            System.out.println(Math.min(adj[n - 1][m - 1][0], adj[n - 1][m - 1][1]));
        } else {
            System.out.println(Math.max(adj[n - 1][m - 1][0], adj[n - 1][m - 1][1]));
        }
    }

    private static String next() {
        if (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
