class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0;
        int right=arr.length-1;
        while(right-left+1>k){
            int leftdist=Math.abs(arr[left]-x);
            int rightdist=Math.abs(arr[right]-x);

            if(leftdist>rightdist){
                left++;
            }else{
                right--;
            }
        }
        List<Integer>result=new ArrayList<>();
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}