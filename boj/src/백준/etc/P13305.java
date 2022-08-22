package 백준.etc;

import java.util.Scanner;

public class P13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] distance = new int[n - 1];
        int[] price = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            price[i] = sc.nextInt();
        }

        long totalPrice = 0;
        long minPrice = 1_000_000_000L;
        for (int i = 0; i < n-1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            totalPrice += minPrice * distance[i];
        }
        System.out.println(totalPrice);
    }
}
