class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        boolean[] visited=new boolean[n];
        int[] minCost=new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);
        minCost[0]=0;
        pq.offer(new Pair(0, 0));
        int totalCost = 0;
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.weight;

            if (visited[node])
                continue;

            visited[node] = true;
            totalCost += cost;

            for (int next = 0; next < n; next++) {
                if (visited[next])
                    continue;

                int newCost =
                        Math.abs(points[node][0] - points[next][0]) +
                        Math.abs(points[node][1] - points[next][1]);

                if (newCost < minCost[next]) {
                    minCost[next] = newCost;
                    pq.offer(new Pair(next, newCost));
                }
            }
        }
        return totalCost;
    }
}
