package 백준.etc;

import java.util.Scanner;

public class P1629 {
    private static final Scanner sc = new Scanner(System.in);
    private static int A, B, C;

    private static void input() {
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
    }

    private static void solve() {
        System.out.println(recursive(A, B, C));
    }

    private static long recursive(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }
        long tmp = recursive(a, b / 2, c);
        if (b % 2 == 0) {
            tmp = tmp * tmp % c;
        } else {
            tmp = tmp * tmp % c * a % c;
        }
        return tmp;
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
