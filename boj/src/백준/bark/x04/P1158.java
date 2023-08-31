package 백준.bark.x04;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!que.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                que.offer(que.poll());
            }
            sb.append(que.poll()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
