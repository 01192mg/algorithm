package 백준.bark.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6593 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int L, R, C;
    static char[][][] map;
    static int[][][] adj;
    static Queue<Integer> que;

    static boolean input() {
        L = nextInt();
        R = nextInt();
        C = nextInt();
        if (L == 0 && R == 0 && C == 0) {
            return false;
        }
        map = new char[L][R][C];
        adj = new int[L][R][C];
        que = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                map[i][j] = next().toCharArray();
                for (int k = 0; k < C; k++) {
                    adj[i][j][k] = -1;
                    if (map[i][j][k] == 'S') {
                        que.offer(i);
                        que.offer(j);
                        que.offer(k);
                        adj[i][j][k] = 0;
                    }
                }
            }
        }
        return true;
    }

    static void solve() {
        while (!que.isEmpty()) {
            Integer z = que.poll();
            Integer y = que.poll();
            Integer x = que.poll();
            if (map[z][y][x] == 'E') {
                System.out.printf("Escaped in %d minute(s).\n", adj[z][y][x]);
                return;
            }
            for (int i = 0; i < dz.length; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) {
                    continue;
                }
                if (adj[nz][ny][nx] != -1 || map[nz][ny][nx] == '#') {
                    continue;
                }
                que.offer(nz);
                que.offer(ny);
                que.offer(nx);
                adj[nz][ny][nx] = adj[z][y][x] + 1;
            }
        }
        System.out.println("Trapped!");
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return st.nextToken();
    }

    public static void main(String[] args) {
        while (input()) {
            solve();
        }
    }
}
