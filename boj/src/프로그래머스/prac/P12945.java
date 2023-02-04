package 프로그래머스.prac;

import 프로그래머스.devmatching.P1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945?language=java
public class P12945 {
    private int[] memo;

    private int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] == 0) {
            memo[n] = fib(n - 2) + fib(n - 1) % 1234567;
        }
        return memo[n];
    }

    public int solution(int n) {
        memo = new int[n + 1];
        return fib(n);
    }

    public static void main(String[] args) {
        P12945 solution = new P12945();
        solution.solution(3);
    }
}
/**
 * 테스트 1 〉	통과 (0.03ms, 77.3MB)
 * 테스트 2 〉	통과 (0.02ms, 72.3MB)
 * 테스트 3 〉	통과 (0.03ms, 78.8MB)
 * 테스트 4 〉	통과 (0.02ms, 68.4MB)
 * 테스트 5 〉	통과 (0.02ms, 72.8MB)
 * 테스트 6 〉	통과 (0.03ms, 78.5MB)
 * 테스트 7 〉	통과 (0.34ms, 71.3MB)
 * 테스트 8 〉	통과 (0.27ms, 75.4MB)
 * 테스트 9 〉	통과 (0.09ms, 77.7MB)
 * 테스트 10 〉	통과 (0.34ms, 75.4MB)
 * 테스트 11 〉	통과 (0.11ms, 74.3MB)
 * 테스트 12 〉	통과 (0.13ms, 74.8MB)
 * 테스트 13 〉	통과 (6.41ms, 80.6MB)
 * 테스트 14 〉	통과 (7.41ms, 83MB)
 */
/**
 * 테스트 1 〉	통과 (0.02ms, 76.5MB)
 * 테스트 2 〉	통과 (0.02ms, 72.2MB)
 * 테스트 3 〉	통과 (0.03ms, 74.5MB)
 * 테스트 4 〉	통과 (0.03ms, 77.8MB)
 * 테스트 5 〉	통과 (0.02ms, 73.8MB)
 * 테스트 6 〉	통과 (0.02ms, 72.5MB)
 * 테스트 7 〉	통과 (0.08ms, 77.2MB)
 * 테스트 8 〉	통과 (0.05ms, 84MB)
 * 테스트 9 〉	통과 (0.03ms, 71MB)
 * 테스트 10 〉	통과 (0.08ms, 75MB)
 * 테스트 11 〉	통과 (0.05ms, 74.3MB)
 * 테스트 12 〉	통과 (0.03ms, 75MB)
 * 테스트 13 〉	통과 (2.32ms, 76.3MB)
 * 테스트 14 〉	통과 (2.27ms, 81.7MB)
 */