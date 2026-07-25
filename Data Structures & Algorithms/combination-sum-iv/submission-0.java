class Solution {

    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {

        dp = new Integer[target + 1];

        return solve(nums, target);
    }

    private int solve(int[] nums, int target) {

        // Base Cases
        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        // Memoization Check
        if (dp[target] != null)
            return dp[target];

        int ans = 0;

        // Try every number
        for (int num : nums) {
            ans += solve(nums, target - num);
        }

        // Store Answer
        dp[target] = ans;

        return dp[target];
    }
}