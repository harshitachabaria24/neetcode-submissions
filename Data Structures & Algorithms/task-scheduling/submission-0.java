class Solution {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            pq.offer(freq);
        }

        Queue<int[]> queue = new LinkedList<>();

        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {

            time++;
            if (!pq.isEmpty()) {

                int current = pq.poll();

                current--;

                if (current > 0) {
                    queue.offer(new int[]{current, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}