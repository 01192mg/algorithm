package etc.그래프와탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3_2251 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = sc.nextInt();
        }
        visit = new boolean[201][201][201];
        possible = new boolean[201];
    }

    static void solve() {
        bfs(0, 0, limit[2]);
        for (int i = 0; i < 201; i++) {
            if (possible[i]) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();
        que.add(new State(new int[]{x1, x2, x3}));
        visit[x1][x2][x3] = true;
        while (!que.isEmpty()) {
            State state = que.poll();
            if (state.x[0] == 0) {
                possible[state.x[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }
                    State next = state.move(from, to, limit);
                    if (visit[next.x[0]][next.x[1]][next.x[2]]) {
                        continue;
                    }
                    que.add(next);
                    visit[next.x[0]][next.x[1]][next.x[2]] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    static class State {
        int[] x;

        State(int[] x) {
            this.x = new int[]{x[0], x[1], x[2]};
        }

        State move(int from, int to, int[] limit) {
            // from에서 to로 물 옮기기
            int[] nx = {x[0], x[1], x[2]};
            if (x[from] + x[to] >= limit[to]) {
                nx[from] -= limit[to] - x[to];
                nx[to] = limit[to];
            } else {
                nx[to] += x[from];
                nx[from] = 0;
            }
            return new State(nx);
        }
    }
}
