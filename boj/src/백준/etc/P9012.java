package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;

    private static void input() throws IOException {
        input = br.readLine();
    }

    private static String solve() {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            input();
            System.out.println(solve());
        }
    }
}
