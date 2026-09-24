package com.zenbox.rateLimiterAlgorithms;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @{source https://medium.com/@anil.goyal0057/rate-limiter-using-token-bucket-algorithm-9911f27ba182}
 * TokenBucket
 */
public class TokenBucket {
    private final int capacity;
    private final int refillRate;
    private final ScheduledExecutorService scheduler;
    private int tokens;

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(5, 1);

        for (int i = 0; i < 20; i++) {
            boolean isAllowed = tokenBucket.allowRequest();
            System.out.println("Request " + (i + 1) + ": " + (isAllowed ? "✅ Allowed" : "❌ Blocked"));
            Thread.sleep(200);
        }

        tokenBucket.shutdown();
    }

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;

        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refillTokens, 1, 1, TimeUnit.SECONDS);

    }

    public synchronized boolean allowRequest() {
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    private void refillTokens() {
        tokens = Math.min(capacity, tokens + refillRate);
    }
}
