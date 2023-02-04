package 프로그래머스.prac;

public class P12918 {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || '9' < c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P12918 p12918 = new P12918();
        System.out.println(p12918.solution("a234"));
    }
}
