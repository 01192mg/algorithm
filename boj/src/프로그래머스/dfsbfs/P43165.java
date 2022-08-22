package 프로그래머스.dfsbfs;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class P43165 {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers, target);
        System.out.println(answer);
        return answer;
    }

    static void dfs(int n, int sum, int[] numbers, int target) {
        if (n >= numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(n + 1, sum + numbers[n], numbers, target);
        dfs(n + 1, sum - numbers[n], numbers, target);
    }

    public static void main(String[] args) {
        P43165 solution = new P43165();
        solution.solution(new int[]{4,1,2,1}, 4);
    }
}
