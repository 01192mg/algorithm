package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P10026 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int n;
    private static String[][] map;
    private static boolean[][] visited;
    private static boolean[][] visited2;
    private static int answer = 0;
    private static int answer2 = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            System.arraycopy(row, 0, map[i], 0, n);
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    answer++;
                    bfs(i, j);
                }
                if (!visited2[i][j]) {
                    answer2++;
                    bfs2(i, j);
                }
            }
        }
        System.out.println(answer);
        System.out.println(answer2);
    }

    private static void bfs(int y, int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(y);
        queue.offer(x);
        visited[y][x] = false;

        while (!queue.isEmpty()) {
            y = queue.poll();
            x = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int ny = y + direction[0];
                int nx = x + direction[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || !map[y][x].equals(map[ny][nx])) {
                    continue;
                }
                queue.offer(ny);
                queue.offer(nx);
                visited[ny][nx] = true;
            }
        }
    }

    private static void bfs2(int y, int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(y);
        queue.offer(x);
        visited[y][x] = false;

        while (!queue.isEmpty()) {
            y = queue.poll();
            x = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int ny = y + direction[0];
                int nx = x + direction[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited2[ny][nx]) {
                    continue;
                }
                if (!map[y][x].equals(map[ny][nx]) && (map[y][x].equals("B") || map[ny][nx].equals("B"))) {
                    continue;
                }
                queue.offer(ny);
                queue.offer(nx);
                visited2[ny][nx] = true;
            }
        }
    }
}
