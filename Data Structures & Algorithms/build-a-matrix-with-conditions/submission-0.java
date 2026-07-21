class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder= topoSort(k,rowConditions);
        List<Integer> colOrder=topoSort(k,colConditions);
         if (rowOrder.isEmpty() || colOrder.isEmpty())
            return new int[0][0];
         int[] rowPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
        }
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            colPos[colOrder.get(i)] = i;
        }
        int[][] ans = new int[k][k];
          for (int num = 1; num <= k; num++) {

            ans[rowPos[num]][colPos[num]] = num;
        }

        return ans;
    }
         private List<Integer> topoSort(int k, int[][] conditions) {

        // Graph
        List<Integer>[] graph = new ArrayList[k + 1];

        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        // Indegree of every node
        int[] indegree = new int[k + 1];
        for (int[] condition : conditions) {

            int u = condition[0];
            int v = condition[1];

            graph[u].add(v);
            indegree[v]++;
        }
         Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= k; i++) {

            if (indegree[i] == 0)
                q.offer(i);
        }
         List<Integer> order = new ArrayList<>();
         while (!q.isEmpty()) {

            int curr = q.poll();

            order.add(curr);

            for (int neighbor : graph[curr]) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        if (order.size() != k)
            return new ArrayList<>();

        return order;
    }
}