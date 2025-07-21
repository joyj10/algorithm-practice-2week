package day1;

import java.util.HashMap;
import java.util.Map;

// 문자열: 단어 공부
// https://www.acmicpc.net/problem/1157
public class Word1157 {
    public static void main(String[] args) {
        String word = "XXxxZzIIIIiZEEEEEEZzzz";
        String result = solution(word);
        System.out.println(result);
    }

    public static String solution(String word) {
        // 대소문자 구분 없이 확인 위해 대문자로 변경
        word = word.toUpperCase();

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1); // 문자수 카운트
        }

        int maxCount = -1;
        char maxChar = '?';
        boolean duplicated = false;

        // 최빈 알파벳 탐색
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Integer count = entry.getValue();
            Character ch = entry.getKey();

            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
                duplicated = false;
            } else if (count == maxCount ) {
                duplicated = true; // 최빈 알파벳 중복 발생
            }
        }

        return duplicated ? "?" : String.valueOf(maxChar);
    }
}
