package day2.reservation.service;

import day2.reservation.domain.Reservation;
import day2.reservation.domain.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ReservationService {

    private final List<Reservation> reserved = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);


    // 예약 저장
    public boolean createReservation(User user, LocalDate date, LocalTime start, LocalTime end) {
        // 예약 중복
        if (!isTimeSlotAvailable(date, start, end)) {
            System.out.println("예약 실패: 해당 시간에 이미 예약이 존재합니다.");
            return false;
        }

        // 예약 저장
        Long id = sequence.addAndGet(1);
        Reservation reservation = new Reservation(id, user, date, start, end);
        reserved.add(reservation);
        return true;
    }

    // 전체 예약 조회
    public List<Reservation> getAllReservations() {
        return this.reserved;
    }

    // 특정 시간대 중복 여부 확인
    private boolean isTimeSlotAvailable(LocalDate date, LocalTime start, LocalTime end) {
        // 예약 충돌 검사
        for (Reservation reservation : this.reserved) {
            if (reservation.getDate().equals(date)) {
                boolean overlap = start.isBefore(reservation.getEndTime()) && reservation.getStartTime().isBefore(end);
                if (overlap) return false;
            }
        }

        return true;
    }
}
