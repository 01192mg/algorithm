package 프로그래머스.pccp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P1 {
    public String solution(String input_string) {
        List<Character> loners = new ArrayList<>();
        int[] cnt = new int['z' + 1];
        char before = 0;
        int i;
        for (i = 0; i < input_string.length(); ) {
            char current = input_string.charAt(i);

            // 연속된 문자 제거
            if (before == current) {
                i++;
                continue;
            }

            // 연속되지 않고 이미 등장한 문자는 외톨이 알파벳으로 판별
            if (cnt[current] == 1) {
                loners.add(current);
            }

            cnt[current]++;
            before = current;
            i++;
        }

        StringBuilder answer = new StringBuilder();

        loners.sort(Comparator.comparingInt(o -> o));
        for (Character loner : loners) {
            answer.append(loner);
        }
        if (answer.length() == 0) {
            answer.append("N");
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        P1 p1 = new P1();
        p1.solution("edeaaabbccd");
        p1.solution("eeddee");
        p1.solution("string");
        p1.solution("zbzbz");
    }
}
