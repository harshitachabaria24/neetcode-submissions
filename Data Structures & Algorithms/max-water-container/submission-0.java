class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxArea=0;
        while(left<right){
            int width=right-left;
            int currentArea=width * Math.min(heights[left],heights[right]);

            maxArea=Math.max(maxArea,currentArea);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
        
        
    }
}
