package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17070 {
    static int N, count;
    static int[][] map;
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};

    private static void input() {
        CustomScanner sc = new CustomScanner();
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void solve() {
        dfs(0, 1, 0);
        System.out.println(count);
    }

    private static void dfs(int y, int x, int direction) {
        if (y == N - 1 && x == N - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if ((direction == 0 && i == 1) || (direction == 1 && i == 0)) {
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 1) {
                continue;
            }
            if (i == 2 && (map[y][x + 1] == 1 || map[y + 1][x] == 1)) {
                continue;
            }
            dfs(ny, nx, i);
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
