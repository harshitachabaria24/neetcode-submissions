class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int currentIndex = n - 1; currentIndex >= 0; currentIndex--) {

            for (int previousIndex = currentIndex - 1;
                 previousIndex >= -1;
                 previousIndex--) {

                int skip = dp[currentIndex + 1][previousIndex + 1];

                int take = 0;

                if (previousIndex == -1 ||
                        nums[previousIndex] < nums[currentIndex]) {

                    take = 1 + dp[currentIndex + 1][currentIndex + 1];
                }

                dp[currentIndex][previousIndex + 1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}