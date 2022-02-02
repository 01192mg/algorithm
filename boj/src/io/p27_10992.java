package io;

import java.io.*;

public class p27_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == n-1) {
                bw.write("*".repeat(n * 2 - 1));
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (n-1-i == j) {
                    bw.write("*");

                } else {
                    bw.write(" ");

                }
            }
            for (int j = 0; j < n; j++) {
                if (i == j+1) {
                    bw.write("*");

                } else if (i > j+1) {
                    bw.write(" ");

                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
