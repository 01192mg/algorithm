package 백준.bark.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
    static final MyScanner sc = new MyScanner();
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};
    static int R, C;
    static Character[][] map;
    static int[][] adj1;
    static int[][] adj2;
    static Queue<Integer> que1 = new ArrayDeque<>();
    static Queue<Integer> que2 = new ArrayDeque<>();

    private static void input() {
        R = sc.nextInt();
        C = sc.nextInt();
        map = new Character[R][C];
        adj1 = new int[R][C];
        adj2 = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] line = sc.nextLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                adj1[i][j] = -1;
                adj2[i][j] = -1;

                if (map[i][j] == 'F') {
                    que1.add(i);
                    que1.add(j);
                    adj1[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    que2.add(i);
                    que2.add(j);
                    adj2[i][j] = 0;
                }
            }
        }
    }

    private static void solve() {
        bfs1();
        bfs2();
    }

    private static void bfs1() {
        while (!que1.isEmpty()) {
            Integer y = que1.poll();
            Integer x = que1.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (map[ny][nx] == '#' || adj1[ny][nx] != -1) {
                    continue;
                }
                que1.offer(ny);
                que1.offer(nx);
                adj1[ny][nx] = adj1[y][x] + 1;
            }
        }
    }

    private static void bfs2() {
        while (!que2.isEmpty()) {
            Integer y = que2.poll();
            Integer x = que2.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    System.out.println(adj2[y][x] + 1);
                    return;
                }
                if (map[ny][nx] == '#' || adj2[ny][nx] != -1) {
                    continue;
                }
                if (adj1[ny][nx] != -1 && adj1[ny][nx] <= adj2[y][x] + 1) {
                    continue;
                }
                que2.offer(ny);
                que2.offer(nx);
                adj2[ny][nx] = adj2[y][x] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class MyScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
