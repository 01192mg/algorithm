package dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1_1463 {
    static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        used = new boolean[n+1];
        int result = bfs(n);
        System.out.println(result);
    }

    public static int bfs(int input) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(input);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (used[x]) {
                    continue;
                }
                used[x] = true;
                if (x == 1) {
                    return count;
                }
                if (x % 3 == 0) {
                    queue.offer(x / 3);
                }
                if (x % 2 == 0) {
                    queue.offer(x / 2);
                }
                queue.offer(x - 1);
            }
            count++;
        }
        return -1;
    }
}