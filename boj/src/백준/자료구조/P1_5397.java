package 백준.자료구조;

import java.util.*;

public class P1_5397 {
    static StringBuilder sb;
    static Scanner sc = new Scanner(System.in);
    static int t;
    static String input;

    static List<Character> list;

    static void input() {
        input = sc.nextLine();
    }

    static void solve() {
        sb = new StringBuilder();
        list = new LinkedList<>();
        int cursor = 0;
        char[] inputs = input.toCharArray();
        for (char input : inputs) {
            if (input == '<') {
                if (cursor > 0) {
                    cursor--;
                }
                continue;
            }

            if (input == '>') {
                if (cursor < list.size()) {
                    cursor++;
                }
                continue;
            }

            if (input == '-') {
                if (cursor > 0) {
                    list.remove(cursor - 1);
                    cursor--;
                }
                continue;
            }

            if (cursor == list.size()) {
                list.add(input);
            } else {
                list.add(cursor, input);
            }
            cursor++;
        }

        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }
}

//2
//<<BP<A>>Cd-
//ThIsIsS3Cr3t

//BAPC
//ThIsIsS3Cr3t