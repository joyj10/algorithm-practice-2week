package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 문자열: 파일명 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=java
public class FileName {
    public static void main(String[] args) {
        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] result = solution(input);
        for (String s : result) {
            System.out.println("### s = " + s);
        }
    }

    public static String[] solution(String[] files) {
        List<FileVo> fileVos = new ArrayList<>();
        for (String fileName : files) {
            Pattern pattern = Pattern.compile("(\\D*)(\\d+)(.*)");
            Matcher matcher = pattern.matcher(fileName);

            if (matcher.matches()) {
                String head = matcher.group(1).toLowerCase();
                int number = Integer.parseInt(matcher.group(2));
                String tail = matcher.group(3).toLowerCase();
                fileVos.add(new FileVo(head, number, tail, fileName));
            }
        }

        Collections.sort(fileVos);

        return fileVos.stream()
                .map(i -> i.originFileName)
                .toArray(String[]::new);
    }

    static class FileVo implements Comparable<FileVo> {
        String head;
        int number;
        String tail;
        String originFileName;

        public FileVo(String head, int number, String tail, String originFileName) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.originFileName = originFileName;
        }

        // head, number, tail 기준으로 정렬
        @Override
        public int compareTo(FileVo o) {
            int headCompare = this.head.compareTo(o.head);
            if (headCompare != 0) {
                return headCompare;
            }

            return Integer.compare(this.number, o.number);
        }
    }
}
