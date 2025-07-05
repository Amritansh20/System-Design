package org.systemDesign.rateLimiter.implementations;

import org.systemDesign.rateLimiter.algorithms.SlidingWindow;

public class SlidingWindowImpl {
    public static void main(String[] args) throws InterruptedException {
        SlidingWindow limiter = new SlidingWindow(3,10);

        String userId = "user1";

        for(int i=1;i<=5;i++){
            boolean allowed = limiter.allowRequest(userId);
            System.out.println("Request "+i + (allowed? " Access": " Denied"));
            Thread.sleep(1000);
        }
    }
}
