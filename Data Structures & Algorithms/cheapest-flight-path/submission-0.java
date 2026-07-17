class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp=distance.clone();
            for(int[] flight:flights){
                int u=flight[0];
                int v=flight[1];
                int cost=flight[2];
                if(distance[u]!=Integer.MAX_VALUE){
                    temp[v]=Math.min(temp[v],distance[u]+cost);
                }
            }
            distance=temp;
        }
        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];
    }
}
