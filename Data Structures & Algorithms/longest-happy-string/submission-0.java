class Solution {
    public String longestDiverseString(int a, int b, int c) {
         PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y[1], x[1])
        );

        if (a > 0) {
            pq.offer(new int[]{'a', a});
        }

        if (b > 0) {
            pq.offer(new int[]{'b', b});
        }

        if (c > 0) {
            pq.offer(new int[]{'c', c});
        }
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            int[] first = pq.poll();

            char ch = (char) first[0];
              // Check if using first would create 3 same characters
            if (result.length() >= 2 &&
                result.charAt(result.length() - 1) == ch &&
                result.charAt(result.length() - 2) == ch) {

                // No second character available
                if (pq.isEmpty()) {
                    break;
                }

                // Take second most frequent character
                int[] second = pq.poll();

                result.append((char) second[0]);
                second[1]--;

                // Put second back if it still has characters
                if (second[1] > 0) {
                    pq.offer(second);
                }
                // Put first back because we couldn't use it
                pq.offer(first);

            } else {

                // We can safely use first
                result.append(ch);
                first[1]--;

                // Put it back if characters remain
                if (first[1] > 0) {
                    pq.offer(first);
                }
            }
        }

        return result.toString();
    }
}