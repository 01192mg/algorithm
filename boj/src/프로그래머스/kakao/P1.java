package 프로그래머스.kakao;

import java.util.ArrayList;
import java.util.List;

public class P1 {
    private static final int MONTH = 12;
    private static final int DAY = 28;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        String[] date = today.split("\\.");
        int days = calculateDays(date);
        for (int i = 0; i < privacies.length; i++) {
            String[] privacie = privacies[i].split(" ");
            String[] privacieDate = privacie[0].split("\\.");
            String type = privacie[1];
            int expDateDays = calculateDays(privacieDate) + typeToDays(terms, type);
            if (expDateDays <= days) {
                result.add(i + 1);
            }
        }
        return resultToAnswer(result);
    }

    private int calculateDays(String[] date) {
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return year * MONTH * DAY + month * DAY + day;
    }

    private int typeToDays(String[] terms, String type) {
        for (String term : terms) {
            String[] typeAndExpDate = term.split(" ");
            String termType = typeAndExpDate[0];
            String termExpMonth = typeAndExpDate[1];
            if (termType.equals(type)) {
                return Integer.parseInt(termExpMonth) * DAY;
            }
        }
        throw new IllegalArgumentException("유효한 약관이 아닙니다");
    }

    private int[] resultToAnswer(List<Integer> result) {
        int[] answer;
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        P1 solution = new P1();
        solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
}
