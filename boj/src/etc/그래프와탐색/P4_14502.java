package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4_14502 {
    static Scanner sc = new Scanner(System.in);

    static int n, m, b, ans;
    static int[][] a, blank;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visit = new boolean[n][m];
        blank = new int[n * m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        if (idx >= b) {
            return;
        }
        a[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, cnt + 1);
        a[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, cnt);
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                if (a[i][j] == 2) {
                    que.add(i);
                    que.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visit[ny][nx]) {
                    continue;
                }
                if (a[ny][nx] == 0) {
                    que.add(ny);
                    que.add(nx);
                    visit[ny][nx] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    blank[b][0] = i;
                    blank[b][1] = j;
                    b++;
                }
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
