package etc.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P2_1015 {
    private static final StringBuilder sb = new StringBuilder();
    private static int n;
    private static Element[] b;
    private static int[] p;

    public static void main(String[] args) {
        input();
        logic();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        b = new Element[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = new Element(sc.nextInt(), i);
        }
    }

    private static void logic() {
        Arrays.sort(b);
        for (int bi = 0; bi < n; bi++) {
            p[b[bi].index] = bi;
        }
        for (int i : p) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    private static class Element implements Comparable<Element> {
        private final int number;
        private final int index;

        public Element(int value, int index) {
            this.number = value;
            this.index = index;
        }

        public int compareTo(Element o) {
            if (number != o.number) {
                return this.number - o.number;
            }
            return this.index - o.index;
        }
    }
}
