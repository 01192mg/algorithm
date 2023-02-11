package 백준.etc;

import java.util.Scanner;

public class P1676 {
    private static final Scanner sc = new Scanner(System.in);
    private static int N;

    private static void input() {
        N = sc.nextInt();
    }

    private static void solve() {
        int count = 0;
        while (N >= 5) {
            System.out.println(N);
            count += N / 5;
            N /= 5;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
