class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        ArrayList<HashSet<Integer>>prere=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            prere.add(new HashSet<>());
        }
        for(int[] edge : prerequisites){

    int pre = edge[0];
    int course = edge[1];

    graph.get(pre).add(course);

    indegree[course]++;
}
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();

            for(int neighbours:graph.get(curr)){
                prere.get(neighbours).add(curr);
                prere.get(neighbours).addAll(prere.get(curr));

                indegree[neighbours]--;
                if(indegree[neighbours]==0){
                    q.offer(neighbours);
                }
            }
        }
        List <Boolean> ans=new ArrayList<>();
        for(int[] query:queries){
            int u=query[0];
            int v=query[1];

            ans.add(prere.get(v).contains(u));
        }
        return ans;
    }
}