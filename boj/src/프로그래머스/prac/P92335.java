package 프로그래머스.prac;

public class P92335 {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder kNotation = new StringBuilder();
        while (n > 0) {
            kNotation.append(n % k);
            n /= k;
        }
        kNotation.reverse();
        for (String candidate : kNotation.toString().split("0+")) {
            if (isPrime(Long.parseLong(candidate))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if (number == 1L) {
            return false;
        }
        double limit = Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P92335 p92335 = new P92335();
        p92335.solution(437674, 3);
        P92335 a = new P92335();
        a.solution(110011, 10);
    }
}
