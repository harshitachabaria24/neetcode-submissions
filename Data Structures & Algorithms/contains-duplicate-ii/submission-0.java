class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
        return false;
        HashSet<Integer> seen=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i]))
            return true;

            seen.add(nums[i]);
            if(seen.size()>k){
                seen.remove(nums[i-k]);
            }
        }
        return false;
    }
}