class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int score = 0;
            int ans = Integer.MIN_VALUE;

            for (int k = 0; k < 3 && i + k < n; k++) {

                score += stoneValue[i + k];

                ans = Math.max(ans, score - dp[i + k + 1]);
            }

            dp[i] = ans;
        }

        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}