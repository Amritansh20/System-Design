package org.systemDesign.rateLimiter.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/*
     Concept:

- Maintain a **log of request timestamps** for each user or key.
- Only allow a request if the number of timestamps in the last `X` seconds is less than the allowed limit.
- Logs slide as time progresses — hence the name Sliding Window.

     Use Case:

Let’s say:

- You want to allow **100 requests per 60 seconds** per user.
- You track each request timestamp.
- If a new request comes in, you remove timestamps older than 60 seconds.
- If the remaining timestamps are < 100 → **allow** the request.

Pros:
Very accurate.
Fair Rate Limiting
Easy to implement and test

cons:
higher memory usage
Slower as log grows
Not ideal for large scale applications.

- **ow-to-medium traffic** applications
- **Exact control** over request count
- When accuracy > performance


Time complexity :
    allowUsers -> O(n)

Space complexity:
    O(n)

*/
public class SlidingWindow {
    private final int maxRequests;
    private final long windowSizeInSeconds;
    private final Map<String, Deque<Long>> userLogs;

    public SlidingWindow(int maxRequests, long windowSizeInSeconds){
        this.maxRequests=maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.userLogs = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId){
            long now = System.currentTimeMillis()/1000; //seconds
            userLogs.putIfAbsent(userId,new ArrayDeque<>());

            Deque<Long> logs = userLogs.get(userId);

            while(!logs.isEmpty() && (now-logs.peekFirst())>windowSizeInSeconds)
                logs.pollFirst();

            if(logs.size() < maxRequests) {
                logs.addLast(now);
                return true;
            }

            return false;
    }
}
