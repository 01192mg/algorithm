package etc.그래프와탐색;

import java.util.*;

public class P2_2667 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n, groupCnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<Integer> group;

    static void input() {
        n = sc.nextInt();
        sc.nextLine();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }
        visit = new boolean[n][n];
    }

    static void solve() {
        group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    groupCnt = 0;
                    dfs(i, j);
                    group.add(groupCnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (Integer cnt : group) {
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        groupCnt++;
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if (a[ny].charAt(nx) == '0') {
                continue;
            }
            if (visit[ny][nx]) {
                continue;
            }
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
