package 백준.그래프;

import java.io.*;
import java.util.*;

public class P2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] inDegrees;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
        print(answer);
    }

    private static void input() {
        N = nextInt();
        M = nextInt();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(nextInt()).add(nextInt());
        }
        inDegrees = new int[N + 1];
    }

    private static void solve() {
        initInDegrees();
        sort();
    }

    private static void initInDegrees() {
        for (List<Integer> from : adj) {
            for (Integer to : from) {
                inDegrees[to]++;
            }
        }
    }

    private static void sort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            for (Integer to : adj.get(from)) {
                if (--inDegrees[to] == 0) {
                    queue.offer(to);
                }
            }
            answer.add(from);
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

    private static void print(List<Integer> input) {
        try {
            for (Integer integer : input) {
                bw.append(String.valueOf(integer)).append(" ");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
