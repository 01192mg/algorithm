package 백준.자료구조;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//N인 수열 A = A1, A2, ..., AN
//A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1
public class P17298 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int[] input;
        int n = sc.nextInt();
        input = new int[n + 1];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        input[n] = 0;
        for (int i = 0; i < n; i++) {
            int a1 = input[i];
            for (int j = i + 1; j < n + 1; j++) {
                int a2 = input[j];
                if (a1 < a2) {
                    sb.append(a2 + " ");
                    input[i] = 0;
                    break;
                }
            }
            if (input[i] != 0) {
                sb.append("-1 ");
            }

        }
        System.out.println(sb);
    }
}
