package 프로그래머스.prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P42627 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(j -> j[1]));

        int count = 0;
        int jobsIndex = 0;
        int now = 0;
        int totalTime = 0;

        while (count < jobs.length) {
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= now) {
                queue.offer(jobs[jobsIndex++]);
            }

            if (queue.isEmpty()) {
                now = jobs[jobsIndex][0];
                continue;
            }

            int[] job = queue.poll();
            totalTime += now + job[1] - job[0];
            now += job[1];
            count++;
        }

        return totalTime / jobs.length;
    }

    public static void main(String[] args) {
        P42627 p42627 = new P42627();
        p42627.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        p42627.solution(
                new int[][]{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43},
                        {26, 1}});

    }
}
