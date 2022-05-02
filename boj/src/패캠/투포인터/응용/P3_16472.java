package 패캠.투포인터.응용;

import java.util.Scanner;

public class P3_16472 {
    static Scanner sc = new Scanner(System.in);
    static int n, kind;
    static String a;
    static int[] cnt;

    static void input() {
        n = sc.nextInt();
        sc.nextLine();
        a = sc.nextLine();
        cnt = new int[26];
    }

    static void add(char x) {
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1) {
            kind++;
        }
    }

    static void delete(char x) {
        cnt[x - 'a']--;
        if (cnt[x - 'a'] == 0) {
            kind--;
        }
    }

    static void solve() {
        int l = 0, len = a.length(), ans = 0;
        for (int r = 0; r < len; r++) {
            add(a.charAt(r));
            while (kind > n) {
                delete(a.charAt(l));
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
