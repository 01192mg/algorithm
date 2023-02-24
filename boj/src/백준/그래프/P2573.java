package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2573 {
    static CustomScanner scanner = new CustomScanner();
    static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] melt;

    private static void input() {
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        visited = new boolean[N][M];
        melt = new int[N][M];
    }

    private static int solve() {
        int day = 0;

        while(true) {
            visited = new boolean[N][M];

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] <= 0 || visited[i][j]) {
                        continue;
                    }
                    visited[i][j] = true;
                    dfs(i, j);
                    cnt++;
                }
            }

            if (1 < cnt) {
                return day;
            }
            if (cnt == 0) {
                return cnt;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] <= 0) {
                        continue;
                    }
                    map[i][j] -= melt[i][j];
                    melt[i][j] = 0;
                }
            }
            day++;
        }
    }

    private static void dfs(int y, int x) {
        for (int[] direction : DIRECTIONS) {
            int ny = y + direction[0];
            int nx = x + direction[1];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }
            if (map[ny][nx] <= 0) {
                melt[y][x]++;
                continue;
            }
            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }
}

class CustomScanner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

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
/*
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
 */
