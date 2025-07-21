package assignment.reservation;

import assignment.reservation.domain.User;
import assignment.reservation.service.ReservationService;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationMain {
    public static void main(String[] args) {
        ReservationService service = new ReservationService();
        User user1 = new User(1L, "홍길동");

        // 예약 시도
        boolean result = service.createReservation(
                user1,
                LocalDate.of(2025, 7, 25),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );

        System.out.println("예약 성공 여부: " + result);
        System.out.println("예약 목록:");
        service.getAllReservations().forEach(System.out::println);

        boolean result2 = service.createReservation(
                user1,
                LocalDate.of(2025, 7, 25),
                LocalTime.of(10, 30),
                LocalTime.of(12, 0)
        );

        System.out.println("예약 성공 여부: " + result2);
        System.out.println("예약 목록:");
        service.getAllReservations().forEach(System.out::println);
    }
}
