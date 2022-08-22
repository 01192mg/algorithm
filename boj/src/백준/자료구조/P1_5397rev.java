package 백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class P1_5397rev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String input = sc.next();
            keyLogger(input);
        }
    }
    // < : stack 1 pop stack 2 push
    // > : stack 2 pop stack 1 push
    // - : stack 1 pop
    // alpha : stack 1 add(char)
    static void keyLogger(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c == '<') {
                if (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }else if (c == '>') {
                if (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else if (c == '-') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        // 비밀번호 출력
        // 앞에서 가져오기 위해 stack1에 있는 값을 전부 stack2로 이동
        // stack2의 값을 꺼내서 sb에 넣어준다.
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }
        System.out.println(sb);
    }
}
