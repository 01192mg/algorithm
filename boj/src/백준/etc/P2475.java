package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2475 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] numbers;

    static void input() throws IOException {
        numbers = br.readLine().split(" ");
    }

    static void solve() {
        int result = 0;
        for (String number : numbers) {
            result += Math.pow(Integer.parseInt(number), 2);
        }
        System.out.println(result % 10);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
