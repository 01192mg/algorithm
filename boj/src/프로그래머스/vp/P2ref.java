package 프로그래머스.vp;

import java.util.Arrays;

public class P2ref {
    private static final int[] PHONE_NUMBER_LENGTH = {13, 11, 16};
    private static final String[] PHONE_NUMBER_PREFIXES = {"010-", "010", "+82-10-"};

    public int solution(String phone_number) {
        char[] numbers = phone_number.toCharArray();
        if (Arrays.stream(PHONE_NUMBER_LENGTH).noneMatch(l -> numbers.length == l)) {
            return -1;
        }

        for (int i = 0; i < PHONE_NUMBER_PREFIXES.length; i++) {
            String prefix = PHONE_NUMBER_PREFIXES[i];
            String suffix = phone_number.substring(prefix.length());
            if (phone_number.startsWith(prefix) && isValidNumber(suffix))
                return i + 1;
        }

        return -1;
    }

    private boolean isValidNumber(String numbers) {
        if (numbers.length() == 9) {
            if (numbers.charAt(4) != '-') {
                return false;
            }
            numbers = numbers.substring(0, 4) + numbers.substring(5);
        }
        for (char number : numbers.toCharArray()) {
            if (number == '-' || number == '+') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P2ref solution = new P2ref();
//        solution.solution("01012345678");
//        solution.solution("1");
//        solution.solution("010-1212-333");
//        solution.solution("010-1212-333");
        solution.solution("+82-10-3434-2323");
//        solution.solution("+82-010-3434-2323");
    }
}
