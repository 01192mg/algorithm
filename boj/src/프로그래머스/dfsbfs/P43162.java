package 프로그래머스.dfsbfs;

//https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class P43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    dfs(i, computers);
                    answer++;
                }
            }
        }
        return answer;
    }

    static void dfs(int i, int[][] computers) {
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1) {
                computers[i][j] = 0;
                computers[j][i] = 0;
                dfs(j, computers);
            }
        }
    }

    public static void main(String[] args) {
        P43162 solution = new P43162();
        solution.solution(3, new int[][]{{1,1,0}, {1,1,0},{0,0,1}});
    }
}
