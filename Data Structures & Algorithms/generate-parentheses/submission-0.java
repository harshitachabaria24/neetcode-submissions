class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        helper(n,0,0,new StringBuilder(),ans);
        return ans;
    }
    public void helper(int n,int open,int close,StringBuilder current,List<String> ans){
        if(current.length()==2*n){
            ans.add(current.toString());
            return ;
        }
        if(open<n){
            current.append('(');
            helper(n,open+1,close,current,ans);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(')');

            helper(n,open,close+1,current,ans);
            current.deleteCharAt(current.length()-1);
        }
    }
}
