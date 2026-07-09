class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int index,int target,List<Integer> path,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i,target-nums[i],path,ans);
            path.remove(path.size()-1);
        }
    }
}
