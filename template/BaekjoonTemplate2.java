import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekjoonTemplate2 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 모아두기
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 명령 수
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            // 로직 작성 위치
            // 예: 명령어 파싱, 조건 처리 등
            sb.append("처리 결과\n");
        }

        // 출력
        System.out.print(sb);
    }
}
