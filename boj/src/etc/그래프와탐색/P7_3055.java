package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7_3055 {
    static Scanner sc = new Scanner(System.in);
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int r, c;
    static String[] map;
    static int[][] distWater;
    static int[][] distHedgehog;

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        map = new String[r];
        for (int i = 0; i < r; i++) {
            map[i] = sc.nextLine();
        }
        distHedgehog = new int[r][c];
        distWater = new int[r][c];
    }

    static void bfsWater() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                distWater[i][j] = -1;
                if (map[i].charAt(j) == '*') {
                    que.add(i);
                    que.add(j);
                    distWater[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if (map[ny].charAt(nx) == 'X' || map[ny].charAt(nx) == 'D') {
                    continue;
                }
                if (distWater[ny][nx] != -1) {
                    continue;
                }
                que.add(ny);
                que.add(nx);
                distWater[ny][nx] = distWater[y][x] + 1;
            }
        }
    }

    static void bfsHedgehog() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                distHedgehog[i][j] = -1;
                if (map[i].charAt(j) == 'S') {
                    que.add(i);
                    que.add(j);
                    distHedgehog[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if (map[ny].charAt(nx) == 'X') {
                    continue;
                }
                if (distHedgehog[ny][nx] != -1) {
                    continue;
                }
                if (distWater[ny][nx] != -1 && distHedgehog[y][x] + 1 >= distWater[ny][nx]) {
                    continue;
                }
                que.add(ny);
                que.add(nx);
                distHedgehog[ny][nx] = distHedgehog[y][x] + 1;
            }
        }
    }

    static void solve() {
        bfsWater();
        bfsHedgehog();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) == 'D') {
                    if (distHedgehog[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(distHedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
