class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum += num;
        }
            if(sum%2 != 0){
                return false;
            }
            int target=sum/2;
            int n=nums.length;
            boolean[][] dp=new boolean[n+1][target+1];

            dp[n][0]=true;
            for(int index=n-1;index>=0;index--){
                for(int currTarget=0;currTarget<=target;currTarget++){
                    boolean skip=dp[index+1][currTarget];
                    boolean take=false;
                    if(nums[index]<=currTarget){
                        take=dp[index+1][currTarget-nums[index]];
                    }
                      dp[index][currTarget] = take || skip;
                }
            }
        return dp[0][target];
    }
}