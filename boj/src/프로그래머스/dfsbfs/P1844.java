package 프로그래머스.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class P1844 {
    public int solution(int[][] maps) {
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int answer;
        bfs(0, 0, dir, maps);
        answer = maps[maps.length - 1][maps[0].length - 1];
        if (answer <= 1) {
            answer = -1;
        }
        return answer;
    }

    static void bfs(int y, int x, int[][] dir, int[][] maps) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(y);
        queue.offer(x);
        while (!queue.isEmpty()) {
            y = queue.poll();
            x = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || maps[ny][nx] != 1) {
                    continue;
                }
                maps[ny][nx] = maps[y][x] + 1;
                queue.offer(ny);
                queue.offer(nx);
            }
        }
    }

    public static void main(String[] args) {
        P1844 solution = new P1844();
        solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
    }
}
