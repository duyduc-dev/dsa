package com.zenbox.rateLimiterAlgorithms;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * https://medium.com/@anil.goyal0057/rate-limiter-sliding-window-logs-algorithm-using-deque-58831661b9ee
 */
public class SlidingWindow {
  private final ConcurrentHashMap<String, Deque<Long>> userRequestMap = new ConcurrentHashMap<>();
  private final long WINDOW_DURATION_MS = TimeUnit.MINUTES.toMillis(1);
  private final int MAX_REQUESTS = 5;

  public static void main(String[] args) throws InterruptedException {
    SlidingWindow limiter = new SlidingWindow();
    String userId = "1";
    // simulating 1 login attempt at start of 1-minute window.
    System.out.println("Request 1: " + (limiter.checkRateLimit(userId) ? "Allowed ✅" : "Blocked ❌"));
    // sleep for 55 seconds
    Thread.sleep(55000);
    // simulating 4 more login attempts in the same 1-minute time window at almost
    // edge of the window.
    for (int i = 0; i <= 3; i++) {
      if (limiter.checkRateLimit(userId)) {
        System.out.println("Login attempt " + (i + 2) + " Allowed ✅.");
      } else {
        System.out.println("Login attempt " + (i + 2) + " Blocked ❌. Too many attempts!");
      }
      // sleep for 5 seconds and 1-minute window expired
      Thread.sleep(5000); // Simulating time gap
    }
    // simulating one more request which slide the window and leave the first login
    // attempt and take this one.
    System.out.println("Request 6: " + (limiter.checkRateLimit(userId) ? "Allowed ✅" : "Blocked ❌"));
    // simulating one more request which comes in existing window only and blocked
    // because it exceed max request.
    System.out.println("Request 7: " + (limiter.checkRateLimit(userId) ? "Allowed ✅" : "Blocked ❌"));
  }

  public synchronized boolean checkRateLimit(String userId) {
    long currTime = System.currentTimeMillis();
    userRequestMap.putIfAbsent(userId, new ConcurrentLinkedDeque<>());

    var timestemptList = userRequestMap.get(userId);

    while (timestemptList != null && currTime - timestemptList.peekFirst() >= WINDOW_DURATION_MS) {
      timestemptList.pollFirst();
    }

    if (timestemptList.size() < MAX_REQUESTS) {
      timestemptList.addLast(currTime);
      return true;
    } else {
      return false;
    }
  }
}
