class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
            int[] degree=new int[n];
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
                degree[u]++;
                degree[v]++;
            }
        Queue <Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);

            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            ans.clear();

            for(int i=0;i<size;i++){
                int curr=q.poll();
                ans.add(curr);
                for(int neighbours:graph.get(curr)){
                    degree[neighbours]--;
                    if(degree[neighbours]==1){
                        q.offer(neighbours);
                    }
                }
            }
        }
        return ans;
    }
}