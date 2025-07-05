package org.systemDesign.rateLimiter.algorithms;


/*Imagine a bucket with a small hole in the bottom:

        - Requests enter the bucket like water.
        - Water leaks out at a constant rate.
        - If the bucket overflows → request is rejected (rate limit hit)


        - Fixed output rate: handles traffic evenly.
        - No burst allowed (unlike Token Bucket).
        - Smoother & fair for downstream systems.
        - There is uniformity unlike Token bucket


         Common Use Cases:

        - Throttling user requests (prevent spamming)
        - Rate-limiting login attempts
        - Limiting API calls per service
 */
public class LeakyBucket {
    private final int capacity;
    private final double leakRatePerSecond;
    private double currentWaterLevel;
    private long lastLeakTimeStamp;

    public LeakyBucket(int capacity, double leakRatePerSecond){
        this.capacity=capacity;
        this.leakRatePerSecond=leakRatePerSecond;
        this.currentWaterLevel=capacity;
        this.lastLeakTimeStamp=System.nanoTime();
    }

    public synchronized boolean allowRequests(){
        leak();

        if(currentWaterLevel<capacity){
            currentWaterLevel++;
            return true;
        }
        return false;
    }

    public void leak(){
        long now = System.nanoTime();
        double elapsedSeconds = (now-lastLeakTimeStamp)/1_000_000_000.0;

        double leaked = elapsedSeconds*leakRatePerSecond;
        if(leaked>0){
            currentWaterLevel=Math.min(capacity,currentWaterLevel-leaked);
            lastLeakTimeStamp= System.nanoTime();
        }
    }
}
