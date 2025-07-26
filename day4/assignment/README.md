# 🧪 구현 과제 – 인기 게시글 순위 시스템

## 📌 문제 설명

어떤 커뮤니티 서비스에서는 사용자의 게시글 조회 기록을 바탕으로 **일일 인기 게시글 순위**를 정합니다.  
**게시글 ID**와 **사용자 ID**, **조회 시간**이 담긴 로그를 기반으로, 다음 조건에 따라 인기 게시글 Top N을 구하세요.

---

## ✅ 조건

1. **동일 사용자가 같은 게시글을 여러 번 본 경우, 1회만 카운트합니다.**
2. **조회 시간**은 `'YYYY-MM-DD hh:mm:ss'` 형식입니다.
3. 특정 **조회일**을 기준으로 해당 날짜의 조회 기록만 포함합니다.
4. **조회수가 높은 순으로 정렬**하되, 동률일 경우 게시글 ID가 작은 순으로 정렬합니다.

---

## 🧾 입력 형식

```java
List<ViewLog> logs = List.of(
  new ViewLog(1, "userA", "2025-07-24 10:00:00"),
  new ViewLog(1, "userA", "2025-07-24 10:30:00"),
  new ViewLog(2, "userB", "2025-07-24 11:00:00"),
  new ViewLog(3, "userC", "2025-07-23 10:00:00"),
  new ViewLog(1, "userB", "2025-07-24 09:30:00"),
  new ViewLog(2, "userC", "2025-07-24 08:30:00")
);
```

- 각 ViewLog는 (게시글 ID, 사용자 ID, 조회 시간)으로 구성됩니다.
```java
int topN = 2;
String targetDate = "2025-07-24";
```

## 출력 예시
```java
List<Integer> result = getPopularPosts(logs, topN, targetDate);
// 출력: [1, 2]
```
- 설명:
  - 1번 게시글은 userA, userB에게 각각 1회 조회됨 (중복 제거됨)
  - 2번 게시글은 userB, userC에게 각각 1회 조회됨 
    - → 조회수 동률일 경우 게시글 번호 오름차순으로 정렬됨

## 클래스 정의
```java
class ViewLog {
    int postId;
    String userId;
    String timestamp; // 예: "2025-07-24 09:30:00"

    public ViewLog(int postId, String userId, String timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }
}
```