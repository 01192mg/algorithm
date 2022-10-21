package 프로그래머스.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P3 {
    private static final int[] SAIL_PERCENT = new int[]{10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int plusServiceUser = 0;
        int income = 0;
        Arrays.sort(emoticons);
        Arrays.sort(users, Comparator.comparingInt(u -> u[0]));
        for (int[] user : users) {
            int percent = user[0];
            int price = user[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        P3 solution = new P3();
        solution.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
    }
}

/**
 * 1번(브론즈상): 가장 쉬움. 문자열을 년도로 바꾸는 것이 귀찮지만 이미 기출에 많이 나왔던 요소입니다.
 * 2번(골드중): 2번치고 어렵. 나도 바로 풀이를 생각해내진 못함. 배달과 수거를 분리한 뒤 뒤쪽부터 생각해야한다는 아이디어가 필요함
 * 3번(실버상): 기초 브루트포스
 * 4번(골드중): 이진트리를 구성한 뒤 dfs를 하면 됨. 다만 비트연산 문제에 익숙하지 않다면 헷갈릴 만한 요소가 많음. 카카오 기출에 비트연산이 많이 나왔기 때문에 평소에 연습하는 것이 중요해 보임
 * 5번(골드중): union find를 적절히 사용하여 풀면 됨. 제한이 작기때문에 롤백은 브루트포스로 가능함. 유파를 안 써도 될 것 같긴 하지만 쓰는 게 편할 듯.
 * 6번(골드중): 기우성이 중요하다는 것과 사전순 최소는 그리디하게 구할 수 있다는 걸 눈치채면 됨. 사전순 최소를 구하는 유형에 익숙하다면 쉬운 문제.
 * 7번(골드상~플레하): 솔직히 증명 안 하고 풂. 대충 최대 턴 수를 10만 정도로 잡으니깐 맞음. 구현도 꽤 귀찮은 편
 */