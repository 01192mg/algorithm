package 백준.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1259 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String input() throws IOException {
        return br.readLine();
    }

    static String solve(String number) {
        StringBuilder reversedNumber = new StringBuilder(number);
        if (reversedNumber.reverse().toString().equals(number)) {
            return "yes";
        }
        return "no";
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = input();
            if (input.equals("0")) {
                break;
            }
            bw.append(solve(input)).write("\n");
        }
        bw.flush();
    }
}
