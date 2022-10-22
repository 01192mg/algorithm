package 백준.그리디;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbers = input.split("[-+]");

        String[] operandTokens = input.split("[0-9]");
        List<String> operands = Arrays.stream(operandTokens)
                .filter(o -> !o.equals(""))
                .collect(Collectors.toList());

        int sum = Integer.parseInt(numbers[0]);
        for (int i = 0; i < operands.size(); i++) {
            if (operands.get(i).equals("-")) {
                while (i < operands.size()) {
                    sum -= Integer.parseInt(numbers[i + 1]);
                    i++;
                }
                break;
            }
            sum += Integer.parseInt(numbers[i + 1]);
        }
        System.out.println(sum);
    }
}
