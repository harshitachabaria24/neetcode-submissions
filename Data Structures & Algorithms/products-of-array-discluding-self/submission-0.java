class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=1;
        }
        int prefix=1;
        for(int i=0;i<n;i++){
            answer[i]=prefix*answer[i];
            prefix=prefix*nums[i];
        }
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            answer[i]=suffix*answer[i];
            suffix=suffix*nums[i];
        }
        return answer;
    }
}  
