class Solution {
     class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {

            if(parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {

            int px = find(x);
            int py = find(y);

            if(px == py) {
                return;
            }

            if(size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            }
            else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU dsu=new DSU(n);
        HashMap<String,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                 if(!map.containsKey(email)) {
                    map.put(email, i);
                }
                else{
                    int prev=map.get(email);
                    dsu.union(prev,i);
                }
            }
        }
        HashMap<Integer,List<String>> merged=new HashMap<>();
        for(String email:map.keySet()){
            int index=map.get(email);
            int parent=dsu.find(index);
            merged.putIfAbsent(parent,new ArrayList<>());
            merged.get(parent).add(email);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int parent:merged.keySet()){
            List <String> emails=merged.get(parent);
            Collections.sort(emails);
            List<String> account=new ArrayList<>();
            account.add(accounts.get(parent).get(0));
            account.addAll(emails);
            ans.add(account);
        }
        return ans;
        
    }
}