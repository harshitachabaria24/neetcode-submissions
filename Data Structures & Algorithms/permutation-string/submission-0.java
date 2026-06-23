class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1count=new int[26];
        int[] window=new int[26];

        for(char ch:s1.toCharArray()){
            s1count[ch-'a']++;
        }
        int left=0;
        for(int right=0;right<s2.length();right++){
            window[s2.charAt(right)-'a']++;
            if(right-left+1 > s1.length()){
                window[s2.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(s1count,window)){
                return true;
            }
        }
        return false;
        
    }
}
