class Solution {

    HashSet<String> set;
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {

        set = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];

        return solve(0, s);
    }

    private boolean solve(int i, String s) {

        if (i == s.length())
            return true;

        if (dp[i] != null)
            return dp[i];

        for (int end = i; end < s.length(); end++) {

            String word = s.substring(i, end + 1);

            if (set.contains(word)) {

                if (solve(end + 1, s)) {
                    dp[i] = true;
                    return true;
                }
            }
        }

        dp[i] = false;
        return false;
    }
}