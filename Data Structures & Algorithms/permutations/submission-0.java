class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        helper(nums,new ArrayList<>(),visited,ans);
        return ans;
    }
    public void helper(int nums[],List<Integer> path,boolean[] visited,List<List<Integer>> ans){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            path.add(nums[i]);
            visited[i]=true;
            helper(nums,path,visited,ans);
            path.remove(path.size()-1);
            visited[i]=false;

        }
    }
}
