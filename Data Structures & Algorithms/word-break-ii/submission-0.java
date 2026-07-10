class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans= new ArrayList<>();
        HashSet<String>dict=new HashSet<>(wordDict);
        helper(s,0,dict,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int index,HashSet<String>dict,List<String>path,List<String>ans){
        if(index==s.length()){
            ans.add(String.join(" ",path));
            return;
        }
        for(int end=index;end<s.length();end++){
            String word=s.substring(index,end+1);
            if(dict.contains(word)){
                path.add(word);
                helper(s,end+1,dict,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
}