package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int M, N;
    static int[][] map;
    static int[][] dp;

    private static void input() {
        M = nextInt();
        N = nextInt();

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = nextInt();
                dp[i][j] = -1;
            }
        }
    }

    private static void solve() {
        dp[0][0] = 1;
        System.out.println(dfs(M - 1, N - 1));
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;

        for (int[] direction : DIRECTIONS) {
            int ny = y + direction[0];
            int nx = x + direction[1];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N || dp[ny][nx] == 0) {
                continue;
            }

            if (map[ny][nx] > map[y][x]) {
                dp[y][x] += dfs(ny, nx);
            }
        }

        return dp[y][x];
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
