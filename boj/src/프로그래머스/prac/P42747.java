package 프로그래머스.prac;

import java.util.Arrays;

//논문 n편 중 h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하인 경우 answer = h
public class P42747 {
    public int solution(int[] citations) {
        int answer = 0;
        for (int i = citations.length; i > 0; i--) {
            int h = i;
            long citation = Arrays.stream(citations).filter(c -> c >= h).count();
            if (citation >= h && (citations.length - citation) <= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42747 p42747 = new P42747();
        p42747.solution(new int[]{3, 0, 6, 1, 5});
    }
}
