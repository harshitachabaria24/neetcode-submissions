class Solution {
    int parent[];
    int [] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        size=new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(find(u)==find(v))
            return edge;
            union(u,v);
        }
        return new int[0];
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY){
            return;
        }
        if(size[rootX]>=size[rootY]){
            parent[rootY]=rootX;
            size[rootX] += size[rootY];

        }else {

            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
}
