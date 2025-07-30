package algorithm;

// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);

        // 5
        System.out.println(result);

    }

    public static int count = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                count++;
            }
            return;
        }

        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
