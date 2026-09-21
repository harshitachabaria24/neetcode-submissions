class Solution {
    public int characterReplacement(String s, int k) {
    int[] count=new int[26];
    int left=0;
    int maxlength=0;
    int maxfre=0;
    for(int right=0;right<s.length();right++){
        int rightindex=s.charAt(right)-'A';
        count[rightindex]++;
        maxfre=Math.max(maxfre,count[rightindex]);
        int windowlength=right-left+1;
        int replacements=windowlength-maxfre;
        if(replacements>k){
            int leftindex=s.charAt(left)-'A';
            count[leftindex]--;
            left++;
        }
        maxlength=Math.max(maxlength,right-left+1);
    }
    return maxlength;
    }
}
