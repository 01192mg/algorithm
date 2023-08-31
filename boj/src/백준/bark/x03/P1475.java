package 백준.bark.x03;

import java.util.Scanner;

public class P1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] spare = new int[10];
        int answer = 0;
        while (input > 0) {
            int num = input % 10;
            input /= 10;
            if (num == 9) {
                num = 6;
            }
            if (spare[num] <= 0) {
                for (int i = 0; i < 10; i++) {
                    spare[i]++;
                }
                spare[6]++;
                answer++;
            }
            spare[num]--;
        }
        System.out.println(answer);
    }
}
