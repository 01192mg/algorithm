package 프로그래머스.vp;

import java.util.Stack;

public class P1ref {
    public boolean solution(int[] arr) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();

        int arrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            stack.push(i+1);
            while (!stack.isEmpty() && stack.peek() == arr[arrIndex]) {
                stack.pop();
                arrIndex++;
            }
        }
        if (arrIndex != arr.length) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        P1ref solution = new P1ref();
        solution.solution(new int[]{1,3,2});
        solution.solution(new int[]{3,1,2});
    }
}
