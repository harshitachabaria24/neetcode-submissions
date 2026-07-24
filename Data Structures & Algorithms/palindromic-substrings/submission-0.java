class Solution {

    public int countSubstrings(String s) {

        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (isPalindrome(i, j, s, dp)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(int i, int j, String s, Boolean[][] dp) {

        // Base Case
        if (i >= j) {
            return true;
        }

        // Already Computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // First and Last Character Mismatch
        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        // Check the Remaining Substring
        dp[i][j] = isPalindrome(i + 1, j - 1, s, dp);

        return dp[i][j];
    }
}