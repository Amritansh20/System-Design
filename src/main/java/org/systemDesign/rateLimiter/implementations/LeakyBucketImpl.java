package org.systemDesign.rateLimiter.implementations;

import org.systemDesign.rateLimiter.algorithms.LeakyBucket;

public class LeakyBucketImpl {

    public static void main(String[] args) {
        LeakyBucket limiter = new LeakyBucket(3,1);

        for(int i=0;i<10;i++){
            boolean allowed = limiter.allowRequests();
            System.out.println("Request "+ i + (allowed? " Allowed ": " Denied"));
        }
    }

}
