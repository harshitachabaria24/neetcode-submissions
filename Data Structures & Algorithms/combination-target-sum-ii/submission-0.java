class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] candidates,int index,int target,List<Integer> path,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<candidates.length;i++){
        if(i > index && candidates[i]==candidates[i-1]){
            continue;
        }
        if(candidates[i] > target) {
        break;
    }
        path.add(candidates[i]);
        helper(candidates,i+1,target-candidates[i],path,ans);
        path.remove(path.size()-1);
        }
    
    }
}
