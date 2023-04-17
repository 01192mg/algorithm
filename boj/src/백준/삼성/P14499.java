package 백준.삼성;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14499 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m, x, y, k;
    static int[][] map;
    static int[] commands;
    static final int[][] dirs = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static void input() {
        n = nextInt();
        m = nextInt();
        x = nextInt();
        y = nextInt();
        k = nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = nextInt();
            }
        }
        commands = new int[k];
        for (int i = 0; i < k; i++) {
            commands[i] = nextInt();
        }
    }

    private static void solve() throws IOException {
        Dice dice = new Dice();
        for (int i = 0; i < k; i++) {
            int nx = x + dirs[commands[i]][0];
            int ny = y + dirs[commands[i]][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            x = nx;
            y = ny;
            dice.move(commands[i]);
            if (map[x][y] == 0) {
                map[x][y] = dice.b;
            } else {
                dice.b = map[x][y];
                map[x][y] = 0;
            }

            bw.write(dice.f + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static class Dice {
        int u, d, l, r, f, b;

        public void move(int direction) {
            if (direction == 1) {
                moveRight();
            } else if (direction == 2) {
                moveRight();
                moveRight();
                moveRight();
            } else if (direction == 3) {
                moveDown();
                moveDown();
                moveDown();
            } else if (direction == 4) {
                moveDown();
            }
        }

        private void moveRight() {
            // l -> f, f -> r, r -> b, b -> l
            int tmp = l;
            l = b;
            b = r;
            r = f;
            f = tmp;
        }

        private void moveDown() {
            // u -> f, f -> d, d -> b, b -> u
            int tmp = u;
            u = b;
            b = d;
            d = f;
            f = tmp;
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

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
