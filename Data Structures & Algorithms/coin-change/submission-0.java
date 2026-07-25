class Solution {

    Integer[] dp;
    int[] coins;

    public int coinChange(int[] coins, int amount) {

        this.coins = coins;
        dp = new Integer[amount + 1];

        int ans = solve(amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int solve(int amount) {

        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (dp[amount] != null)
            return dp[amount];

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res = solve(amount - coin);

            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + res);
            }
        }

        dp[amount] = ans;
        return dp[amount];
    }
}