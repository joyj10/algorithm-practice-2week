package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 스택 : 균형 잡힌 세상
// https://www.acmicpc.net/problem/4949
public class Stack4949 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 모아두기
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            // 종료 요청 시 종료 처리
            if (".".equals(input)) {
                break;
            }

            boolean isBalanced = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }

            // 남은 괄호가 있으면 불균형
            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            String result = isBalanced ? "yes" : "no";
            sb.append(result).append("\n");
        }

        // 출력
        System.out.print(sb);
    }
}

