package 프로그래머스.prac;

// 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로
// 단어 기준으로 짝/홀 판단.
// s	return
//"try hello world"	"TrY HeLlO WoRlD"
public class P12930 {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                wordIndex = 0;
                continue;
            }
            if (wordIndex % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
            wordIndex++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        P12930 p12930 = new P12930();
        p12930.solution("try hello world");
    }
}
