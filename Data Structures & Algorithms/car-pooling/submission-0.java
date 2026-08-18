class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        // 1. Sort trips by pickup location
        Arrays.sort(trips, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        // 2. Min Heap based on drop-off location
        // int[0] = passengers
        // int[1] = destination
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int currentPassengers = 0;

        // 3. Process trips from left to right
        for (int[] trip : trips) {

            // 4. Remove passengers whose trip has ended
            while (!pq.isEmpty() &&
                   pq.peek()[1] <= trip[1]) {

                currentPassengers -= pq.poll()[0];
            }

            // 5. Pick up new passengers
            currentPassengers += trip[0];

            // 6. Check capacity
            if (currentPassengers > capacity) {
                return false;
            }

            // 7. Add this trip to heap
            pq.offer(new int[]{trip[0], trip[2]});
        }

        return true;
    }
}