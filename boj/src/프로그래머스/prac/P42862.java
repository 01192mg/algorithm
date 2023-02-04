package 프로그래머스.prac;

import java.util.Arrays;

public class P42862 {
    private boolean[] isLost;
    private boolean[] isReserve;

    private void init(int n, int[] lost, int[] reserve) {
        isLost = new boolean[n + 1];
        isReserve = new boolean[n + 1];
        for (int l : lost) {
            isLost[l] = true;
        }
        for (int r : reserve) {
            isReserve[r] = true;
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int result = n;
        init(n, lost, reserve);
        for (int i = 1; i <= n; i++) {
            if (isLost[i]) {
                int from = findReserve(i);
                if (from == 0) {
                    result--;
                }
                isReserve[from] = false;
            }
        }
        return result;
    }

    private int findReserve(int i) {
        if (isReserve[i]) {
            return i;
        }
        if (i - 1 >= 1 && isReserve[i - 1]) {
            return i - 1;
        }
        if (i + 1 < isReserve.length && isReserve[i + 1] && !isLost[i + 1]) {
            return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        P42862 p42862 = new P42862();
        p42862.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }
}
/**
 * 테스트 1 〉	통과 (1.70ms, 73.6MB) 테스트 2 〉	통과 (1.09ms, 76.9MB) 테스트 3 〉	통과 (1.08ms, 76.5MB) 테스트 4 〉	통과 (1.48ms, 76.4MB) 테스트 5
 * 〉	통과 (1.06ms, 73.7MB) 테스트 6 〉	통과 (1.24ms, 76.3MB) 테스트 7 〉	통과 (1.11ms, 78.1MB) 테스트 8 〉	통과 (1.05ms, 73.3MB) 테스트 9 〉	통과
 * (1.08ms, 72.3MB) 테스트 10 〉	통과 (0.98ms, 75.8MB) 테스트 11 〉	통과 (1.05ms, 77.7MB) 테스트 12 〉	통과 (1.61ms, 75.7MB) 테스트 13 〉	통과
 * (1.02ms, 73.3MB) 테스트 14 〉	통과 (1.53ms, 73.8MB) 테스트 15 〉	통과 (1.21ms, 77.5MB) 테스트 16 〉	통과 (1.15ms, 78.5MB) 테스트 17 〉	통과
 * (1.15ms, 84.5MB) 테스트 18 〉	통과 (1.20ms, 71.2MB) 테스트 19 〉	통과 (1.29ms, 72.9MB) 테스트 20 〉	통과 (1.24ms, 73.4MB) 테스트 21 〉	통과
 * (1.11ms, 76MB) 테스트 22 〉	통과 (1.43ms, 76.9MB) 테스트 23 〉	통과 (1.16ms, 75.6MB) 테스트 24 〉	통과 (1.09ms, 74.4MB) 테스트 25 〉	통과
 * (1.24ms, 73.3MB)
 */

/**
 * 테스트 1 〉	통과 (0.03ms, 79.9MB)
 * 테스트 2 〉	통과 (0.03ms, 75.1MB)
 * 테스트 3 〉	통과 (0.02ms, 74.2MB)
 * 테스트 4 〉	통과 (0.03ms, 68.4MB)
 * 테스트 5 〉	통과 (0.02ms, 73.5MB)
 * 테스트 6 〉	통과 (0.04ms, 71.1MB)
 * 테스트 7 〉	통과 (0.02ms, 66.2MB)
 * 테스트 8 〉	통과 (0.04ms, 72.7MB)
 * 테스트 9 〉	통과 (0.02ms, 85.7MB)
 * 테스트 10 〉	통과 (0.02ms, 80MB)
 * 테스트 11 〉	통과 (0.02ms, 66.8MB)
 * 테스트 12 〉	통과 (0.03ms, 76.9MB)
 * 테스트 13 〉	통과 (0.04ms, 72.5MB)
 * 테스트 14 〉	통과 (0.03ms, 76.2MB)
 * 테스트 15 〉	통과 (0.03ms, 79.1MB)
 * 테스트 16 〉	통과 (0.04ms, 75.6MB)
 * 테스트 17 〉	통과 (0.05ms, 83.4MB)
 * 테스트 18 〉	통과 (0.04ms, 65.8MB)
 * 테스트 19 〉	통과 (0.02ms, 77.2MB)
 * 테스트 20 〉	통과 (0.02ms, 77MB)
 * 테스트 21 〉	통과 (0.02ms, 66.9MB)
 * 테스트 22 〉	통과 (0.03ms, 70.2MB)
 * 테스트 23 〉	통과 (0.03ms, 66.5MB)
 * 테스트 24 〉	통과 (0.06ms, 76.2MB)
 * 테스트 25 〉	통과 (0.03ms, 77.4MB)
 */