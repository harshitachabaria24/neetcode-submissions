class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    private int solve(int i, String s, int[] dp) {

        // Successfully decoded the whole string
        if (i == s.length()) {
            return 1;
        }

        // String starting with 0 is invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take one digit
        int ways = solve(i + 1, s, dp);

        // Take two digits if possible
        if (i + 1 < s.length()) {

            int num = (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += solve(i + 2, s, dp);
            }
        }

        dp[i] = ways;

        return dp[i];
    }
}