package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BFS: 바이러스
// https://www.acmicpc.net/problem/2606
public class Bfs2606 {
    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // 입력 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 수
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        // 그래프 초기화
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        int result = bfs(1);
        System.out.println(result);
    }

    private static int bfs(int i) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();

            if (!visited[start]) {
                result++;
                visited[start] = true;
                ArrayList<Integer> list = graph[start];
                for (Integer point : list) {
                    if (!visited[point]) {
                        queue.add(point);
                    }
                }
            }
        }

        return result - 1;
    }
}
