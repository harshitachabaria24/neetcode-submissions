class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int index,List<Integer>path,List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            helper(nums,i+1,path,ans);
            path.remove(path.size()-1);
        }
    }
}
