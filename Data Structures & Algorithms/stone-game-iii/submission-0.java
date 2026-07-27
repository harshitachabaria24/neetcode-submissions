class Solution {

    public int solve(int i, int[] stoneValue, Integer[] dp) {

        // Base Case
        if (i == stoneValue.length) {
            return 0;
        }

        // Already computed
        if (dp[i] != null) {
            return dp[i];
        }

        int score = 0;
        int ans = Integer.MIN_VALUE;

        // Try taking 1, 2 or 3 stones
        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {

            // Sum of stones taken
            score += stoneValue[i + k];

            // Current gain - opponent's best advantage
            ans = Math.max(ans,
                    score - solve(i + k + 1, stoneValue, dp));
        }

        return dp[i] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        Integer[] dp = new Integer[n];

        int difference = solve(0, stoneValue, dp);

        if (difference > 0)
            return "Alice";
        else if (difference < 0)
            return "Bob";
        else
            return "Tie";
    }
}