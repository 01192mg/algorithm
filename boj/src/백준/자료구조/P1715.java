package 백준.자료구조;

import java.util.*;

public class P1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // q.poll, q. poll
        // a + b // 13
        // total += 13
        // q.offer 13
        // ...
        // while (q.size > 1)
        // total += q.offer

        int count = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            count += sum;
            queue.offer(sum);
        }
        System.out.println(count);
    }
}
