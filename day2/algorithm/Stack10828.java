package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/10828
public class Stack10828 {

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 모아두기
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 명령 수

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String commandLine = br.readLine();

            String command = commandLine;
            if (command.startsWith("push")) {
                command = "push";
            }

            switch (command) {
                case "push":
                    String[] s = commandLine.split(" ");
                    stack.push(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        // 출력
        System.out.print(sb);
    }
}
