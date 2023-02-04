package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2164 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> queue = new ArrayDeque<>();

    static void input() throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
    }

    static void solve() {
        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
