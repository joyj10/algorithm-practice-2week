package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1966
public class Queue1966 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 모아두기
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 명령 수
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[1]);

            String input2 = br.readLine();
            String[] command2 = input2.split(" ");

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < command2.length; j++ ) {
                int docPriority = Integer.parseInt(command2[j]);
                queue.add(new Document(j, docPriority));
                priorityQueue.add(docPriority);
            }

            int count = 0;
            while (true) {
                Document doc = queue.poll();
                if (doc.priority == priorityQueue.peek()) {
                    priorityQueue.poll();
                    count++;

                    if (index == doc.order) {
                        break;
                    }
                } else {
                    queue.add(doc);
                }
            }

            sb.append(count).append("\n");
        }

        // 출력
        System.out.print(sb);
    }

    public static class Document {
        int order;
        int priority;

        public Document(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
