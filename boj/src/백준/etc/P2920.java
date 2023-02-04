package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;

    private static void input() throws IOException {
        input = br.readLine();
    }

    private static String solve() {
        final String ASCENDING = "1 2 3 4 5 6 7 8";
        final String DESCENDING = "8 7 6 5 4 3 2 1";

        if (ASCENDING.equals(input)) {
            return "ascending";
        }
        if (DESCENDING.equals(input)) {
            return "descending";
        }
        return "mixed";
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }
}
