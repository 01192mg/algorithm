package 프로그래머스.prac;

public class P43238 {
    long MAX_CUSTOMER_SIZE = 1_000_000_000;
    long MAX_TIME = 1_000_000_000;

    public long solution(int n, int[] times) {
        long left = 0;
        long right = MAX_CUSTOMER_SIZE * MAX_TIME;
        long answer = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) {
                sum += (mid / time);
            }
            if (n <= sum) {
                answer = mid;
                right = mid - 1;

            }
            if (n > sum) {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P43238 p43238 = new P43238();
        p43238.solution(6, new int[]{7, 10});
    }
}
