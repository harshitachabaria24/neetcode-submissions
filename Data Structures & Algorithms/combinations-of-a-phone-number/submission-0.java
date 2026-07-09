class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String[] map={
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        helper(digits,0,new StringBuilder(),ans,map);
        return ans;
    }
    public void helper(String digits,int index,StringBuilder current,List<String>ans,String[] map){
        if(index==digits.length()){
            ans.add(current.toString());
            return;
        }
        int digit=digits.charAt(index)-'0';
        String letters=map[digit];
        for(int i=0;i<letters.length();i++){
            current.append(letters.charAt(i));
            helper(digits,index+1,current,ans,map);
            current.deleteCharAt(current.length()-1);
        }
    }
}
