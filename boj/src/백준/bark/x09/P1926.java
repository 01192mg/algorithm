package 백준.bark.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int max;

    private static void solve() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private static void bfs(int y, int x) {
        int size = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(y);
        que.offer(x);
        visited[y][x] = true;
        size++;

        while (!que.isEmpty()) {
            y = que.poll();
            x = que.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0 || visited[ny][nx]) {
                    continue;
                }
                que.offer(ny);
                que.offer(nx);
                visited[ny][nx] = true;
                size++;
            }
        }
        max = Math.max(max, size);
    }

    private static void input() {
        n = nextInt();
        m = nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = nextInt();
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

    public static void main(String[] args) {
        input();
        solve();
    }
}
