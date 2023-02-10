package 백준.etc;

import java.util.Scanner;

public class P1043 {
    private static final Scanner sc = new Scanner(System.in);
    private static int N, r, c;
    private static int seq = 0;

    private static void input() {
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
    }

    private static void solve(int yStart, int yEnd, int xStart, int xEnd) {
        if (xStart == xEnd) {
            System.out.println(seq);
            return;
        }

        int yMid = (yEnd + yStart) / 2;
        int xMid = (xEnd + xStart) / 2;
        int len = (yMid - yStart) + 1;
        if (r <= yMid && c <= xMid) {
            solve(yStart, yMid, xStart, xMid);
        } else if (r <= yMid) {
            seq += len * len;
            solve(yStart, yMid, xMid + 1, xEnd);
        } else if (c <= xMid) {
            seq += 2 * (len * len);
            solve(yMid + 1, yEnd, xStart, xMid);
        } else {
            seq += 3 * (len * len);
            solve(yMid + 1, yEnd, xMid + 1, xEnd);
        }
    }

    public static void main(String[] args) {
        input();
        solve(0, (int) Math.pow(2, N) - 1, 0, (int) Math.pow(2, N) - 1);
    }
}
