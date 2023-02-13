package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987 {
    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited = new boolean[100];
    static int R, C;
    static char[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() {
        R = nextInt();
        C = nextInt();
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = next().toCharArray();
            System.arraycopy(chars, 0, map[i], 0, chars.length);
        }
    }

    private static void solve() {
        visited[map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(result);
    }

    private static void dfs(int y, int x, int depth) {
        result = Math.max(result, depth);
        for (int[] direction : DIRECTIONS) {
            int ny = y + direction[0];
            int nx = x + direction[1];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[map[ny][nx]]) {
                continue;
            }

            visited[map[ny][nx]] = true;
            dfs(ny, nx, depth+1);
            visited[map[ny][nx]] = false;
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
}
