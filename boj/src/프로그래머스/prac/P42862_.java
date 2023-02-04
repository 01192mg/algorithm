package 프로그래머스.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P42862_ {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> list = new ArrayList<>();
        for (int i : lost) {
            list.add(i);
        }
        boolean[] isReserve = new boolean[n + 1];
        for (int i : reserve) {
            isReserve[i] = true;
        }
        for (int i : lost) {
            if (isReserve[i]) {
                isReserve[i] = false;
                list.remove(Integer.valueOf(i));
            }
        }
        Collections.sort(list);
        int answer = n - list.size();
        for (int i : list) {
            int before = i - 1;
            int after = i + 1;
            if (before >= 1 && isReserve[before]) {
                answer++;
                isReserve[before] = false;
            } else if (after <= n && isReserve[after]) {
                answer++;
                isReserve[after] = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42862_ p42862 = new P42862_();
        p42862.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }
}

/**
 * 테스트 1 〉	통과 (0.22ms, 75.4MB)
 * 테스트 2 〉	통과 (0.24ms, 82.8MB)
 * 테스트 3 〉	통과 (0.33ms, 72.5MB)
 * 테스트 4 〉	통과 (0.21ms, 73.3MB)
 * 테스트 5 〉	통과 (0.29ms, 78MB)
 * 테스트 6 〉	통과 (0.31ms, 79.2MB)
 * 테스트 7 〉	통과 (0.20ms, 75.3MB)
 * 테스트 8 〉	통과 (0.19ms, 74.8MB)
 * 테스트 9 〉	통과 (0.31ms, 74.9MB)
 * 테스트 10 〉	통과 (0.25ms, 78.3MB)
 * 테스트 11 〉	통과 (0.22ms, 67.7MB)
 * 테스트 12 〉	통과 (0.27ms, 80.1MB)
 * 테스트 13 〉	통과 (0.21ms, 75.8MB)
 * 테스트 14 〉	통과 (0.20ms, 72.3MB)
 * 테스트 15 〉	통과 (0.31ms, 74.2MB)
 * 테스트 16 〉	통과 (0.19ms, 76.1MB)
 * 테스트 17 〉	통과 (0.18ms, 72.9MB)
 * 테스트 18 〉	통과 (0.29ms, 69.6MB)
 * 테스트 19 〉	통과 (0.20ms, 71.7MB)
 * 테스트 20 〉	통과 (0.20ms, 80.3MB)
 * 테스트 21 〉	통과 (0.26ms, 76.3MB)
 * 테스트 22 〉	통과 (0.31ms, 76.3MB)
 * 테스트 23 〉	통과 (0.38ms, 73.2MB)
 * 테스트 24 〉	통과 (0.23ms, 70.5MB)
 * 테스트 25 〉	통과 (0.29ms, 72.8MB)
 */