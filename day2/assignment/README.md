# Day2: 과제형 – 예약 시스템 API 설계

## 🛠️ 요구사항 시나리오 (간소화 버전)
### [상황]
당신은 회의실 예약 시스템을 설계 중이며, 아래 기능을 구현해야 합니다:

### [기능 요구사항]
1. 사용자는 회의실을 특정 시간에 예약할 수 있다. 
2. 하나의 시간대에는 하나의 예약만 가능하다. 
3. 모든 예약 목록을 조회할 수 있다.

## 클래스 구조
- User: 예약자
- Reservation: 예약 정보
- ReservationService: 예약 처리 비즈니스 로직

## 기본 도메인 설계
``` java
// 유저
public class User {
    private Long id;
    private String name;
}

// 예약 요청
public class Reservation {
    private Long id;
    private User user;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
```

## 기본 서비스 클래스
```java
public class ReservationService {
    // 예약 저장
    public boolean createReservation(User user, LocalDate date, LocalTime start, LocalTime end) {
        // 중복 검사 → 저장
    }

    // 전체 예약 조회
    public List<Reservation> getAllReservations() {
        // 리스트 반환
    }

    // 특정 시간대 중복 여부 확인
    private boolean isTimeSlotAvailable(LocalDate date, LocalTime start, LocalTime end) {
        // 예약 충돌 검사
    }
}
```

## ProgrammersTemplate 클래스 예시
```java
public class ReservationMain {
    public static void main(String[] args) {
        ReservationService service = new ReservationService();
        User user1 = new User(1L, "정지원");

        // 예약 시도
        boolean result = service.createReservation(user1, LocalDate.of(2025, 7, 25),
                LocalTime.of(10, 0), LocalTime.of(11, 0));

        System.out.println("예약 성공 여부: " + result);
        System.out.println("예약 목록:");
        service.getAllReservations().forEach(System.out::println);
    }
}
```

## 실행 예시
```java
예약 성공 여부: true  
예약 목록:  
Reservation{id=1, user=홍길동, date=2025-07-25, 10:00 ~ 11:00}
