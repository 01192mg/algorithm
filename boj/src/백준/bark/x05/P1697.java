package 백준.bark.x05;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] adj = new int[200_001];
        Arrays.fill(adj, -1);
        Queue<Integer> que = new ArrayDeque<>();
        adj[n] = 0;
        que.offer(n);
        while (adj[k] == -1) {
            n = que.poll();
            for (int nn : new int[]{n - 1, n + 1, n * 2}) {
                if (nn < 0 || nn >= adj.length || adj[nn] != -1) {
                    continue;
                }
                que.offer(nn);
                adj[nn] = adj[n] + 1;
            }
        }
        System.out.println(adj[k]);
    }
}
