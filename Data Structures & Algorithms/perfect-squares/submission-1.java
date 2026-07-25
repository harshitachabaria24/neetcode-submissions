class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int square=1;square*square<=i;square++){
                int val=square*square;
                if(dp[i-val] != Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-val]);
                }
            }
        }
        return dp[n];

    }
}