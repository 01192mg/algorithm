package dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = bfs(number);
        System.out.println(result);
    }

    public static int bfs(int input) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(input, 0);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int x = tmp.value;
            int level = tmp.level;
            if (x == 1) {
                return tmp.level;
            }
            if (x % 3 == 0) {
                queue.offer(new Node(x / 3, level + 1));
            }
            if (x % 2 == 0) {
                queue.offer(new Node(x / 2, level + 1));
            }
            queue.offer(new Node(x - 1, level + 1));
        }
        return -1;
    }

    static class Node {
        int value;
        int level;

        public Node(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }
}

/*
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.

input -> 1
횟수
 */