class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[] nums,int index,int xor){
        if(index==nums.length){
            return xor;
        }
        int take=helper(nums,index+1,xor^nums[index]);
        int skip=helper(nums,index+1,xor);

        return take+skip;
    }
}