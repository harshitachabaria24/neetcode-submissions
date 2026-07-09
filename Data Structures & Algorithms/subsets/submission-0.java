class Solution {
     List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(int[] nums,int index,List<Integer> path,List<List<Integer>>ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        helper(nums,index+1,path,ans);

        path.remove(path.size()-1);
        helper(nums,index+1,path,ans);
    }
}
