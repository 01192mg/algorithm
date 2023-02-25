package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2636 {
    static CustomScanner sc = new CustomScanner();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n, m, cheese, removedCheese;
    static int[][] map;
    static boolean[][] isEdge;
    static boolean[][] visited;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    cheese++;
                }
                map[i][j] = input;
            }
        }
    }

    private static void solve() {
        int count = 1;
        while (true) {
            isEdge = new boolean[n][m];
            checkEdge(0, 0);
            visited = new boolean[n][m];
            removedCheese = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }

            if (cheese - removedCheese == 0) {
                break;
            }
            cheese -= removedCheese;
            count++;
        }
        System.out.println(count);
        System.out.println(removedCheese);
    }

    private static void checkEdge(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= m) {
            return;
        }
        if (isEdge[y][x] || map[y][x] == 1) {
            return;
        }
        isEdge[y][x] = true;
        for (int i = 0; i < 4; i++) {
            checkEdge(y + dy[i], x + dx[i]);
        }
    }

    private static void dfs(int y, int x) {
        if (visited[y][x] || map[y][x] == 0) {
            return;
        }
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (map[y][x] == 1 && isEdge[ny][nx]) {
                map[y][x] = 0;
                removedCheese++;
                continue;
            }
            dfs(y + dy[i], x + dx[i]);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class CustomScanner {
        BufferedReader br;
        StringTokenizer st;

        public CustomScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
