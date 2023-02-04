package 백준.삼성;

import java.util.Scanner;

public class P13460 {
    static Scanner sc = new Scanner(System.in);
    static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int N, M;
    static String[][] map;
    static Point R;
    static Point B;
    static int result = 0;

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String[] row = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                switch (row[j]) {
                    case "R":
                        R = new Point(i, j);
                        break;
                    case "B":
                        B = new Point(i, j);
                        break;
                }
            }
        }
    }

    private static void solve() {
//        Queue<Point> queue = new LinkedList<>();
//        queue.add()
        int rX = R.getX();
        int rY = R.getY();

    }

    public static void main(String[] args) {
        input();
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        solve();
    }

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
