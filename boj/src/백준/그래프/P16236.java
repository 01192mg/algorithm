package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int[][] DISTANCE = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Shark shark;
    static int result = 0;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> candidates = new PriorityQueue<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = nextInt();
                if (n == 9) {
                    shark = new Shark(i, j);
                }
                map[i][j] = n;
            }
        }
        visited = new boolean[N][N];
    }

    private static void solve() {
        while (true) {
            dfs(shark.y, shark.x);

            if (candidates.isEmpty()) {
                break;
            }

            Point p = candidates.poll();
            shark.move(p.y, p.x);
            shark.eat();
            result += p.d;

            candidates.clear();
        }
        System.out.println(result);
    }

    private static void dfs(int y, int x) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
        map[y][x] = 0;

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(y, x, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            y = point.y;
            x = point.x;

            for (int[] dist : DISTANCE) {
                int ny = y + dist[0];
                int nx = x + dist[1];
                int nd = point.d + 1;

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] > shark.size) {
                    continue;
                }

                if (nd <= minDistance) {
                    queue.offer(new Point(ny, nx, nd));
                    visited[ny][nx] = true;
                    if (map[ny][nx] != 0 && map[ny][nx] < shark.size) {
                        candidates.add(new Point(ny, nx, nd));
                        minDistance = nd;
                    }
                }
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

    static class Shark {
        int y;
        int x;
        int size;
        int exp;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
            this.size = 2;
        }

        public void move(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void eat() {
            exp++;

            if (exp == size) {
                size++;
                exp = 0;
            }
        }
    }


    static class Point implements Comparable<Point> {
        int y;
        int x;
        int d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            if (d != o.d) {
                return d - o.d;
            }
            if (y != o.y) {
                return y - o.y;
            }
            return x - o.x;
        }
    }
}
