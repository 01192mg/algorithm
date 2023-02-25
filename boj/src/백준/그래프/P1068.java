package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, removed;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] childCount;
    static int[] parents;

    static void input() {
        N = nextInt();
        childCount = new int[N];
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int parent = nextInt();
            if (parent == -1) {
                continue;
            }
            adj.get(parent).add(i);
            childCount[parent]++;
            parents[i] = parent;
        }
        removed = nextInt();
    }

    static void solve() {
        childCount[parents[removed]]--;
        dfs(removed);
        int answer = 0;
        for (int count : childCount) {
            if (count == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int from) {
        if (childCount[from] == -1) {
            return;
        }

        for (Integer to : adj.get(from)) {
            childCount[from]--;
            dfs(to);
        }

        if (childCount[from] == 0) {
            childCount[from] = -1;
        }
    }

    private static int nextInt() {
        if (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
