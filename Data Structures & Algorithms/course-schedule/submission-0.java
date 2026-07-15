class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] edge:prerequisites){
            int course=edge[0];
            int prereq=edge[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int completed=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            completed++;
        for(int neighbours:graph.get(curr)){
            indegree[neighbours]--;
            if(indegree[neighbours]==0){
                q.offer(neighbours);
            }
        }
    }
    return completed==numCourses;
    }
}
