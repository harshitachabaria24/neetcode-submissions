class Solution {

    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        dp = new Integer[n][n + 1];

        return solve(0, -1, nums);
    }

    private int solve(int currentIndex, int previousIndex, int[] nums) {

        if (currentIndex == nums.length)
            return 0;

        if (dp[currentIndex][previousIndex + 1] != null)
            return dp[currentIndex][previousIndex + 1];

        int skip = solve(currentIndex + 1, previousIndex, nums);

        int take = 0;

        if (previousIndex == -1 || nums[previousIndex] < nums[currentIndex]) {

            take = 1 + solve(currentIndex + 1, currentIndex, nums);
        }

        dp[currentIndex][previousIndex + 1] = Math.max(take, skip);

        return dp[currentIndex][previousIndex + 1];
    }
}