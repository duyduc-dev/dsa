package com.zenbox.rateLimiterAlgorithms;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Next: https://medium.com/@anil.goyal0057/rate-limiter-sliding-window-logs-algorithm-using-deque-58831661b9ee
 * FixedWindow
 */
public class FixedWindow {
    private final ConcurrentHashMap<String, RateLimitInfo> userMapping = new ConcurrentHashMap<>();
    private final long WINDOW_DURATION_MS = TimeUnit.MINUTES.toMillis(1);
    private final int MAX_REQUESTS = 5;

    public synchronized boolean checkRateLimitByUserId(String userId) {
        long currTime = System.currentTimeMillis();
        RateLimitInfo rateLimit = userMapping.get(userId);

        if (rateLimit == null || currTime - rateLimit.getStartTime() >= WINDOW_DURATION_MS) {
            rateLimit = new RateLimitInfo(currTime);
            userMapping.put(userId, rateLimit);
        }

        if (rateLimit.getRequestCount() < MAX_REQUESTS) {
            rateLimit.increment();
            return true;
        }

        return false;
    }

    public static class RateLimitInfo {
        private int requestCount;
        private long startTime;

        public RateLimitInfo(long startTime) {
            this.startTime = startTime;
            this.requestCount = 0;
        }

        public void increment() {
            requestCount++;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public long getStartTime() {
            return startTime;
        }

    }
}
