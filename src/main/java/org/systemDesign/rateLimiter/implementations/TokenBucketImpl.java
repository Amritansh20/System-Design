package org.systemDesign.rateLimiter.implementations;

import org.systemDesign.rateLimiter.algorithms.TokenBucket;

public class TokenBucketImpl {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket limiter = new TokenBucket(3,1);

        for(int i=0;i<10;i++){
            boolean allowed = limiter.allowRequests();
            System.out.println("Request "+i +": "+ (allowed ? " Allowed" : "Denied"));
            Thread.sleep(50);
        }
    }
}
