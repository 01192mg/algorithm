package 백준.자료구조;

import java.util.*;

public class p3190 {
    static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Scanner sc = new Scanner(System.in);
    static int[][] board;
    static int n, k, l;
    static Deque<int[]> dirs = new ArrayDeque<>();
    static Queue<int[]> snakePixels = new ArrayDeque<>();
    static int[] seconds;
    static String[] rotates;
    static int inputIndex;
    static int headY, headX;
    static int tailY, tailX;
    static int dy, dx;
    static int time;

    static void input() {
        n = sc.nextInt();
        board = new int[n][n];
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            board[y-1][x-1] = 1;
        }
        l = sc.nextInt();
        seconds = new int[l];
        rotates = new String[l];
        sc.nextLine();
        for (int i = 0; i < l; i++) {
            String[] input = sc.nextLine().split(" ");
            seconds[i] = Integer.parseInt(input[0]);
            rotates[i] = input[1];
        }
        dirs.addAll(Arrays.asList(DIRECTIONS));
    }

    static void solve() {
        initializeGame();
        while (true) {
            boolean isContinue = nextRound();
            if (!isContinue){
                break;
            }
        }
        // 끝나는 시간 출력
        System.out.println(time);
    }

    private static void initializeGame() {
        //뱀 초기 위치 0, 0, 오른쪽 방향
        headY = 0;
        headX = 0;
        tailY = 0;
        tailX = 0;
        snakePixels.offer(new int[]{0, 0});
        board[0][0] = -1;
        int[] dir = dirs.peek();
        dy = dir[0];
        dx = dir[1];
    }

    private static boolean nextRound() {
        time++;
        if (!moveHead()) {
            return false;
        }
        moveTail();
        rotate(time);
        return true;
    }

    private static boolean moveHead() {
        int ny = headY + dy;
        int nx = headX + dx;
        // 벽 or 자기 몸 부딪히면 끝
        if (ny < 0 || nx < 0 || n <= ny || n <= nx || board[ny][nx] == -1) {
            return false;
        }
        headY = ny;
        headX = nx;
        snakePixels.offer(new int[]{headY, headX});
        return true;
    }

    private static void moveTail() {
        if (board[headY][headX] != 1) {
            //이동했을 때 사과 없으면 꼬리 칸 지움(몸 길이 그대로)
            removeTail();
        }
        board[headY][headX] = -1;
    }

    private static void removeTail() {
        int[] tailPoint = snakePixels.poll();
        int y = tailPoint[0];
        int x = tailPoint[1];
        board[y][x] = 0;
    }

    private static void rotate(int second) {
        if (inputIndex >= l || seconds[inputIndex] != second) {
            return;
        }
        String rotate = rotates[inputIndex];
        if (rotate.equals("D")) {
            // 90도 회전
            dirs.offer(dirs.poll());
        } else {
            // -90도 회전
            dirs.offerFirst(dirs.pollLast());
        }
        int[] dir = dirs.peek();
        dy = dir[0];
        dx = dir[1];
        inputIndex++;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
