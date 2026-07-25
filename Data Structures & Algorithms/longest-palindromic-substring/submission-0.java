class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start=0;
        int maxlength=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1||dp[i+1][j-1]){
                        dp[i][j]=true;
                        int currentlength=j-i+1;
                        if(currentlength>maxlength){
                            maxlength=currentlength;
                            start=i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+maxlength);
    }
}
