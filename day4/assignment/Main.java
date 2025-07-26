package assignment;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 입력
        List<ViewLog> logs = List.of(
                new ViewLog(1, "userA", "2025-07-24 10:00:00"),
                new ViewLog(1, "userA", "2025-07-24 10:30:00"),
                new ViewLog(2, "userB", "2025-07-24 11:00:00"),
                new ViewLog(3, "userC", "2025-07-23 10:00:00"),
                new ViewLog(1, "userB", "2025-07-24 09:30:00"),
                new ViewLog(2, "userC", "2025-07-24 08:30:00")
        );

        int topN = 2;
        String targetDate = "2025-07-24";

        // 출력
        List<Integer> result = getPopularPosts(logs, topN, targetDate);
        System.out.println("result = " + result);
        // 출력: [1, 2]
    }

    public static List<Integer> getPopularPosts(List<ViewLog> logs, int topN, String targetDatetime) {
        String targetDate = getDate(targetDatetime);

        Map<Integer, Set<String>> postUserMap = new HashMap<>();
        for (ViewLog log : logs) {
            if (getDate(log.timestamp).equals(targetDate)) {
                postUserMap.computeIfAbsent(log.postId, k -> new HashSet<>()).add(log.userId);
            }
        }

        return postUserMap.entrySet().stream()
                .sorted((e1, e2) -> {
                    int viewSort = Integer.compare(e1.getValue().size(), e2.getValue().size());
                    if (viewSort == 0) {
                        return Integer.compare(e1.getKey(), e2.getKey());
                    }
                    return viewSort;
                })
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static String getDate(String dateTime) {
        if (dateTime == null) throw new NullPointerException("dateTime is null");
        return dateTime.split(" ")[0];
    }

}
