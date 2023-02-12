package 백준.그래프;

import java.io.*;
import java.util.StringTokenizer;

public class P11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        n = nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = nextInt();
            }
        }
    }

    private static int nextInt() throws IOException {
        if (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void solve() throws IOException {
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (map[s][k] == 1 && map[k][e] == 1){
                        map[s][e] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.append(String.valueOf(map[i][j])).append(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
