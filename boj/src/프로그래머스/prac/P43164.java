package 프로그래머스.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P43164 {
    String departures = "ICN";
    boolean[] visited;
    List<String> routes = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        sortTicketsAsc(tickets);

        dfs(departures, departures, tickets, 0);

        return routes.get(0).split(" ");
    }

    private void sortTicketsAsc(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
    }

    private void dfs(String departures, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (departures.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        P43164 p43164 = new P43164();
        p43164.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println();
        P43164 a = new P43164();
        a.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }
}
// 출발 -> 도착
// 다 순회해야 함.
// 2쌍이 주어짐