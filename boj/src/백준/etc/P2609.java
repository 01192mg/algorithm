package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int num1;
    static int num2;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        if (num2 < num1) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
    }

    static void solve() {
        int gcd = gcd(num1, num2);
        int lcm = num1 * num2 / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int num1, int num2) {
        int remainder = num1 % num2;
        if (remainder == 0) {
            return num2;
        }
        return gcd(num2, remainder);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
