class Solution {

    Integer[] dp;

    public int integerBreak(int n) {

        dp = new Integer[n + 1];

        return solve(n);
    }

    private int solve(int n) {

        if (n == 1)
            return 1;

        if (dp[n] != null)
            return dp[n];

        int ans = 0;

        for (int i = 1; i < n; i++) {

            ans = Math.max(
                    ans,
                    Math.max(
                            i * (n - i),
                            i * solve(n - i)
                    )
            );
        }

        dp[n] = ans;
        return dp[n];
    }
}