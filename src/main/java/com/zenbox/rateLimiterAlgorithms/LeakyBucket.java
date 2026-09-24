package com.zenbox.rateLimiterAlgorithms;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LeakyBucket {
    private final LinkedBlockingQueue<Long> bucket;
    private final ScheduledExecutorService scheduler;

    public static void main(String[] args) throws InterruptedException {
        LeakyBucket rateLimiter = new LeakyBucket(5, 2); // 5 max requests, 2 processed/sec

        // Simulate burst traffic: 7 requests arrive in quick succession
        for (int i = 0; i < 7; i++) {
            rateLimiter.allowRequest();
            Thread.sleep(100); // Requests arrive at short intervals
        }

        // Wait a bit and send more requests to see smooth processing
        Thread.sleep(3000);
        System.out.println("New Requests after some time:");

        for (int i = 0; i < 3; i++) {
            rateLimiter.allowRequest();
            Thread.sleep(500);
        }

        rateLimiter.shutdown();
    }

    public LeakyBucket(int capacity, int leakRatePerSecond) {
        this.bucket = new LinkedBlockingQueue<>(capacity);

        this.scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::leakRequest, 0, 1000 / leakRatePerSecond, TimeUnit.MILLISECONDS);
    }

    private void leakRequest() {
        if (!bucket.isEmpty()) {
            bucket.poll();
            System.out.println("Processed a request ✅, Bucket size: " + bucket.size());
        }
    }

    public void allowRequest() {
        if (bucket.remainingCapacity() > 0) {
            bucket.offer(System.currentTimeMillis());
            System.out.println("Request added ✅, Bucket size: " + bucket.size());
        } else {
            System.out.println("Request dropped ❌, Bucket is full!");
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
