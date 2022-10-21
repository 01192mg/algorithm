package etc.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1_11725test {
    static MyScanner sc = new MyScanner();
    static int n;
    static List<Integer>[] adj;
    static int[] parent;

    static void input() {
        n = sc.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void solve() {

    }

    public static void main(String[] args) {
        input();
        for (List<Integer> integers : adj) {
            for (Integer integer : integers) {
                System.out.println(integer
                );
            }
        }
    }

    static class MyScanner {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
