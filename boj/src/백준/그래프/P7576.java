package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;
    private static int[][] box;
    private static int[][] adj;

    private static void input() throws IOException {
        m = nextInt();
        n = nextInt();
        box = new int[n][m];
        adj = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = nextInt();
            }
        }
    }

    private static int nextInt() throws IOException {
        if (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        int remainTomato = 0;

        Queue<Integer> next = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    next.offer(i);
                    next.offer(j);
                } else if (box[i][j] == 0) {
                    remainTomato++;
                }
            }
        }

        while (!next.isEmpty()) {
            Integer y = next.poll();
            Integer x = next.poll();

            for (int i = 0; i < dir.length; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || box[ny][nx] != 0) {
                    continue;
                }
                next.offer(ny);
                next.offer(nx);
                remainTomato--;
                box[ny][nx] = 1;
                adj[ny][nx] = adj[y][x] + 1;
            }
        }

        int day = -1;
        if (remainTomato == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    day = Math.max(day, adj[i][j]);
                }
            }
        }
        System.out.println(day);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
