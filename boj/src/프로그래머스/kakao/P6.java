package 프로그래머스.kakao;

public class P6 {
    private static final int[][] DIRECTION = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private static final String[] DIRECTION_STRING = new String[]{"d", "l", "r", "u"};
    private String answer = "z";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x, y, r, c, k, 0, "");
        if (answer.equals("z")) {
            return "impossible";
        }
        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, String directions) {
        if (depth == k) {
            if (x == r && y == c) {
                answer = directions;
            }
            return;
        }
        if (answer.compareTo(directions) < 0) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION[i][0];
            int ny = y + DIRECTION[i][1];
            if (0 < nx && nx <= n && 0 < ny && ny <= m) {
                dfs(n, m, nx, ny, r, c, k, depth + 1, directions + DIRECTION_STRING[i]);
            }
        }
    }

    public static void main(String[] args) {
        P6 solution = new P6();
        solution.solution(3, 4, 2, 3, 3, 1, 5);
//        solution.solution(2, 2, 1, 1, 2, 2, 2);
    }
}
