package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 스택: 괄호의 값
// https://www.acmicpc.net/problem/2504
public class Stack2504 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Deque<Object> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            // 열린 괄호 stack 추가 ( [
            if (ch == '(' || ch == '[') {
                stack.push(ch);

                // 닫힌 괄호 나오는 경우 처리
            } else if (ch == ')' || ch == ']') {
                int sum = 0;

                while (!stack.isEmpty()) {
                    Object top = stack.pop();

                    if (top instanceof Integer) {
                        sum += (int) top;
                    } else if (top instanceof Character) {
                        char topChar = (char) top;
                        if ((ch == ')' && topChar == '(') || ch == ']' && topChar == '[') {
                            int number = ch == ')' ? 2 : 3;
                            stack.push(sum == 0 ? number : sum * number);
                            break;
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }

        }

        int result = 0;
        for (Object obj : stack) {
            if (!(obj instanceof Integer)) {
                System.out.println(0); // 계산 완료되지 않은 괄호가 남아 있음
                return;
            }
            result += (int) obj;
        }

        System.out.println(result);
    }
}
