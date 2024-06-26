package 힙;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/seat-reservation-manager/description/
 * 1845 / Seat Reservation Manager
 */
public class 힙_좌석예약_1845 {
    public static void main(String[] args) {
        SeatManager sm = new SeatManager(5);
        System.out.println(sm.reserve()); // 1
        System.out.println(sm.reserve()); // 2
        sm.unreserve(2);
        System.out.println(sm.reserve()); // 2
        System.out.println(sm.reserve()); // 3
        System.out.println(sm.reserve()); // 4
        System.out.println(sm.reserve()); // 5
    }

    public static class SeatManager {
        PriorityQueue<Integer> pq;

        public SeatManager(int n) {
            // 초기화: n개의 좌석을 가진 예약 시스템을 초기화합니다.
            pq = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                pq.offer(i);
            }
        }

        // 좌석 예약: 가장 작은 번호의 빈 좌석을 예약하고, 그 번호를 반환합니다.
        public int reserve() {
            return pq.poll();

        }

        // 좌석 해제: 지정된 좌석 번호를 비웁니다.
        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);

        }
    }

}
/*
이 문제는 좌석 예약 시스템을 구현하는 문제입니다.
이 문제를 해결하기 위해서는 최소 힙(PriorityQueue)을 사용하여 효율적으로 가장 낮은 번호의 빈 좌석을 추적할 수 있습니다.
최소 힙을 사용하면 `reserve()` 메서드가 O(log n) 시간 복잡도로 실행될 수 있으며, `unreserve()` 메서드 역시 O(log n) 시간 복잡도로 실행될 수 있습니다.

1. `PriorityQueue<Integer>`를 사용하여 빈 좌석을 추적합니다.
2. 초기화 시, 모든 좌석 번호를 힙에 추가합니다.
3. `reserve()` 메서드에서 힙의 루트 요소(가장 작은 요소)를 제거하고 반환합니다.
4. `unreserve(int seatNumber)` 메서드에서 주어진 좌석 번호를 힙에 다시 추가합니다.
 */



