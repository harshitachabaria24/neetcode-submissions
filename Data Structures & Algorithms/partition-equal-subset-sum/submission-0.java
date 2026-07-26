class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        dp = new Boolean[nums.length][sum / 2 + 1];

        return solve(0, sum / 2, nums);
    }

    private boolean solve(int index, int target, int[] nums) {

        if (target == 0)
            return true;

        if (target < 0)
            return false;

        if (index == nums.length)
            return false;

        if (dp[index][target] != null)
            return dp[index][target];

        boolean take =
            solve(index + 1,
                  target - nums[index],
                  nums);

        boolean skip =
            solve(index + 1,
                  target,
                  nums);

        dp[index][target] = take || skip;

        return dp[index][target];
    }
}