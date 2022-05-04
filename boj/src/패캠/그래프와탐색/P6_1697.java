package 패캠.그래프와탐색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P6_1697 {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[] dist;

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        dist = new int[100_001];
        Arrays.fill(dist, -1);
    }

    static void bfs(int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        dist[n] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 0; i < 3; i++) {
                int y;
                if (i == 0) {
                    y = x + 1;
                } else if (i == 1) {
                    y = x - 1;
                } else {
                    y = x * 2;
                }

                if (y < 0 || y > 100_000 || dist[y] != -1) {
                    continue;
                }

                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void solve() {
        bfs(n);
        System.out.println(dist[k]);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
