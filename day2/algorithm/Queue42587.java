package algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42587
public class Queue42587 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int result = solution(priorities, location);
        // 5
        System.out.println("### result = " + result);

    }

    public static int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            queue.add(new Document(priority, i));
            priorityQueue.add(priority);
        }

        int count = 0;
        while (true) {
            Document doc = queue.poll();
            if (doc.priority == priorityQueue.peek()) {
                priorityQueue.poll();
                count++;

                if (doc.order == location) {
                    break;
                }
            } else {
                queue.add(doc);
            }
        }

        return count;
    }

    public static class Document {
        int priority;
        int order;

        public Document(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }
    }

}
