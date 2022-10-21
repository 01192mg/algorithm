package 프로그래머스.devmatching;

import java.util.EmptyStackException;
import java.util.Stack;

public class P1 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                try {
                    stack.pop();
                } catch (EmptyStackException e) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P1 solution = new P1();
        solution.solution(")()(");
    }
}
