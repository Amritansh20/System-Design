// When to use token Bucket? When you have a burst traffic.
// You need to ensure long term rate limiting.
// suitable for API's, login, messaging system

package org.systemDesign.rateLimiter.algorithms;

import java.util.concurrent.locks.ReentrantLock;


public class TokenBucket {
        private final int capacity;                 // max number of tokens bucket can hold
        private final double refillRatePerSecond;   // tokens added per second
        private double tokens;                      // current numbers of tokens in bucket
        private long lastRefillTimeStamp;           // last time stamp when bucket was refilled

    private final ReentrantLock lock = new ReentrantLock();

        public TokenBucket(int capacity, double refillRatePerSecond){
            this.capacity=capacity;
            this.refillRatePerSecond=refillRatePerSecond;
            this.tokens=capacity;
            this.lastRefillTimeStamp = System.nanoTime();
        }

        public boolean allowRequests(){
            lock.lock();
            try{
                refill();
                if(tokens>0){
                    tokens -=1;
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }

        private void refill(){
            long now = System.nanoTime();
            double secondsElapsed = (now-lastRefillTimeStamp)/1_000_000_000.0;
            double tokensAdded = secondsElapsed*refillRatePerSecond;

            if(tokensAdded>0){
                tokens = Math.min(tokens+tokensAdded,capacity);
                lastRefillTimeStamp= now;
            }
        }


}
