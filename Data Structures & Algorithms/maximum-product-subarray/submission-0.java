class Solution {
    public int maxProduct(int[] nums) {
        int prevMax=nums[0];
        int prevMin=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int tempMax=prevMax;
            int tempMin=prevMin;
            prevMax=Math.max(nums[i],Math.max(nums[i]*tempMax,nums[i]*tempMin));
            prevMin=Math.min(nums[i],Math.min(nums[i]*tempMax,nums[i]*tempMin));
            ans=Math.max(ans,prevMax);

        }
        return ans;
    }
}
