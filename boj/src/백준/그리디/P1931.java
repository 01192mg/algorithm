package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1931 {
    static CustomScanner sc = new CustomScanner();
    static Queue<Meeting> meetings = new PriorityQueue<>();
    static int n;

    private static void input() {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            meetings.offer(new Meeting(sc.nextInt(), sc.nextInt()));
        }
    }

    private static void solve() {
        int currentTime = 0;
        int count = 0;
        while (!meetings.isEmpty()) {
            Meeting meeting = meetings.poll();
            if (meeting.start < currentTime) {
                continue;
            }
            currentTime = meeting.end;
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }

    private static class CustomScanner {
        BufferedReader br;
        StringTokenizer st;

        public CustomScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
