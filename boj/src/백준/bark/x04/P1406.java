package 백준.bark.x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            stack1.push(c);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            try {
                switch (command) {
                    case "L":
                        stack2.push(stack1.pop());
                    case "D":
                        stack1.push(stack2.pop());
                        break;
                    case "B":
                        stack1.pop();
                        break;
                    case "P":
                        stack1.push(st.nextToken().charAt(0));
                        break;
                }
            } catch (Exception ignored) {
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack2) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
