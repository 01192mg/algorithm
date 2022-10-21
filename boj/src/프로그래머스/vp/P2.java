package 프로그래머스.vp;

public class P2 {
    public int solution(String phone_number) {
        char[] numbers = phone_number.toCharArray();
        if (numbers.length != 11 && numbers.length != 13 && numbers.length != 16) {
            return -1;
        }
        if (numbers.length == 13) {
            if (phone_number.startsWith("010-")) {
                for (int i = 4; i < numbers.length; i++) {
                    char number = numbers[i];
                    if (i == 9) {
                        if (number != '-') {
                            return -1;
                        }
                    } else if (numbers[i] == '-' || numbers[i] == '+') {
                        return -1;
                    }
                }
                return 1;
            }
        }

        if (numbers.length == 11) {
            if (phone_number.startsWith("010")) {
                for (char number : numbers) {
                    if (number == '-' || number == '+') {
                        return -1;
                    }
                }
                return 2;
            }
        }

        if (numbers.length == 16) {
            if (phone_number.startsWith("+82-10-")) {
                for (int i = 7; i < numbers.length; i++) {
                    char number = numbers[i];
                    if (i == 11) {
                        if (number != '-') {
                            return -1;
                        }
                    } else if (numbers[i] == '-' || numbers[i] == '+') {
                        return -1;
                    }
                }
                return 3;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P2 solution = new P2();
        solution.solution("01012345678");
        solution.solution("1");
        solution.solution("010-1212-333");
        solution.solution("+82-10-3434-2323");
        solution.solution("+82-010-3434-2323");
    }
}
