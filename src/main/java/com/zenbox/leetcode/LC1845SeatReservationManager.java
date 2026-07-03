package com.zenbox.leetcode;

import java.util.PriorityQueue;

/**
 * {@code LC1845SeatReservationManager}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/seat-reservation-manager/">1845. Seat
 * Reservation Manager</a>.
 * </p>
 */
public class LC1845SeatReservationManager {

  class SeatManager2 {

    PriorityQueue<Integer> seatFree = new PriorityQueue<>();
    int p = 1;

    public SeatManager2(int n) {
      p = 1;
    }

    public int reserve() {
      if (!seatFree.isEmpty()) {
        return seatFree.poll();
      }

      return p++;
    }

    public void unreserve(int seatNumber) {
      seatFree.add(seatNumber);
    }
  }

  class SeatManager {

    PriorityQueue<Integer> seatFree = new PriorityQueue<>();

    public SeatManager(int n) {
      for (int i = 1; i <= n; i++) {
        seatFree.add(i);
      }
    }

    public int reserve() {
      return seatFree.poll();
    }

    public void unreserve(int seatNumber) {
      seatFree.add(seatNumber);
    }
  }

  /**
   * Your SeatManager object will be instantiated and called as such:
   * SeatManager obj = new SeatManager(n);
   * int param_1 = obj.reserve();
   * obj.unreserve(seatNumber);
   */
}
