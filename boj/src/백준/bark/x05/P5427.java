package 백준.bark.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int h, w;
    static Queue<Integer> que1;
    static Queue<Integer> que2;
    static int[][] adj1;
    static int[][] adj2;
    static Character[][] map;

    private static void input() {
        w = nextInt();
        h = nextInt();
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
        adj1 = new int[h][w];
        adj2 = new int[h][w];
        map = new Character[h][w];
        for (int i = 0; i < h; i++) {
            char[] row = next().toCharArray();
            for (int j = 0; j < row.length; j++) {
                adj1[i][j] = -1;
                adj2[i][j] = -1;
                char c = row[j];
                if (c == '*') {
                    que1.offer(i);
                    que1.offer(j);
                    adj1[i][j] = 0;
                } else if (c == '@') {
                    que2.offer(i);
                    que2.offer(j);
                    adj2[i][j] = 0;
                }
                map[i][j] = row[j];
            }
        }
    }

    private static void solve() {
        while (!que1.isEmpty()) {
            Integer y = que1.poll();
            Integer x = que1.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                    continue;
                }
                if (adj1[ny][nx] != -1 || map[ny][nx] == '#') {
                    continue;
                }
                que1.offer(ny);
                que1.offer(nx);
                adj1[ny][nx] = adj1[y][x] + 1;
            }
        }

        while (!que2.isEmpty()) {
            Integer y = que2.poll();
            Integer x = que2.poll();
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                    System.out.println(adj2[y][x] + 1);
                    return;
                }
                if (adj2[ny][nx] != -1 || map[ny][nx] == '#') {
                    continue;
                }
                if (adj1[ny][nx] != -1 && adj2[y][x] + 1 >= adj1[ny][nx]) {
                    continue;
                }
                que2.offer(ny);
                que2.offer(nx);
                adj2[ny][nx] = adj2[y][x] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static int nextInt() {
        return Integer.parseInt(next());
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

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }
}
