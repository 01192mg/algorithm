package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1010 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] numbers;

    static void input() throws IOException {
        numbers = br.readLine().split(" ");
    }

    static void solve() {

    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            input();
            solve();
        }
    }
}
