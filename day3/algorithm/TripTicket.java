package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 여행 경로
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class TripTicket {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution(tickets);

        // ["ICN", "JFK", "HND", "IAD"]
        System.out.println(Arrays.toString(result));
    }

    private static boolean[] visited;
    private static List<String> finalRoutes = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(finalRoutes);
        return finalRoutes.getFirst().split(" ");
    }

    private static void dfs(String current, String route, String[][] tickets, int count) {
        System.out.println("current = " + current);
        System.out.println("route = " + route);
        if (count == tickets.length) {
            finalRoutes.add(route);
            System.out.println("finalRoutes = " + finalRoutes);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            System.out.println(i + " " + ticket[0] + " " + ticket[1]);
            if (!visited[i] && ticket[0].equals(current)) {
                visited[i] = true;
                dfs(ticket[1], route + " " + ticket[1], tickets, count+1);

                // 백트랙킹
                visited[i] = false;
            }
        }

    }
}
