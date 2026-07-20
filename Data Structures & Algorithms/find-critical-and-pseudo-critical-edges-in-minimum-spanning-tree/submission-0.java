
class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private int kruskal(int n, int[][] edges, int ignoreEdge, int forceEdge) {

        DSU dsu = new DSU(n);

        int cost = 0;
        int edgesTaken = 0;

        // Force include an edge
        if (forceEdge != -1) {
            int[] edge = edges[forceEdge];

            dsu.union(edge[0], edge[1]);
            cost += edge[2];
            edgesTaken++;
        }

        for (int i = 0; i < edges.length; i++) {

            if (i == ignoreEdge || i == forceEdge)
                continue;

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                cost += wt;
                edgesTaken++;
            }
        }

        if (edgesTaken != n - 1)
            return Integer.MAX_VALUE;

        return cost;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int m = edges.length;

        // {u, v, weight, originalIndex}
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int mstCost = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            // Check Critical
            int costWithout = kruskal(n, newEdges, i, -1);

            if (costWithout > mstCost) {
                critical.add(newEdges[i][3]);
            } else {

                // Check Pseudo-Critical
                int costWith = kruskal(n, newEdges, -1, i);

                if (costWith == mstCost) {
                    pseudo.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);

        return ans;
    }
}