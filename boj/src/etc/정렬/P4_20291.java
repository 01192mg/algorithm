package etc.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P4_20291 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static String[] extensions;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        extensions = new String[n];
        for (int i = 0; i < n; i++) {
            extensions[i] = sc.nextLine().split("\\.")[1];
        }
    }

    private static void solve() {
        Arrays.sort(extensions);
        for (int i = 0; i < n;) {
            int cnt = 1, j = i + 1;
            for (; j < n; j++) {
                if (extensions[i].equals(extensions[j])) {
                    cnt++;
                } else {
                    break;
                }
            }
            sb.append(extensions[i]).append(' ').append(cnt).append('\n');
            i = j;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb);
    }
}
