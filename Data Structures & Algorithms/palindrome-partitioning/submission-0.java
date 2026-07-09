class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int index,List<String>path,List<List<String>>ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end=index;end<s.length();end++){
            if(isPalindrome(s,index,end)){
                String part=s.substring(index,end+1);
                path.add(part);
                helper(s,end+1,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
