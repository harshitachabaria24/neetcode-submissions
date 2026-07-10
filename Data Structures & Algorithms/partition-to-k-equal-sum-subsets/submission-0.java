class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        if(sum%k != 0){
            return false;
        }
        int target=sum/k;
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
         boolean[] visited = new boolean[nums.length];

        return helper(nums, visited, 0, k, 0, target);
    }
    public boolean helper(int[] nums,
                          boolean[] visited,
                          int start,
                          int k,
                          int currentSum,
                          int target) {

        if (k == 1) {
            return true;
        }
        if (currentSum == target) {
            return helper(nums, visited, 0, k - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (currentSum + nums[i] > target) {
                continue;
            }

            visited[i] = true;

            if (helper(nums,
                       visited,
                       i + 1,
                       k,
                       currentSum + nums[i],
                       target)) {

                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}