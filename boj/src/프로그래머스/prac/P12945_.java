package 프로그래머스.prac;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945?language=java
public class P12945_ {
    private int[] fib;

    public int solution(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 2] + fib[i - 1]) % 1234567;
        }

        return fib[n];
    }

    public static void main(String[] args) {
        P12945_ solution = new P12945_();
        solution.solution(3);
    }
}

