class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp = new boolean[n+1];

        dp[n]=true;
        for(int i=n-1;i>=0;i--){
            for(int end=i;end<n;end++){
                String word=s.substring(i,end+1);
                if(set.contains(word) && dp[end+1]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}