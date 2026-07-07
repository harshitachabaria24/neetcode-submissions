/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
            helper(root);
            return maxsum;
    }
    public int helper(TreeNode root){
        if(root==null)
        return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        maxsum=Math.max(maxsum,left+right+root.val);
        return root.val+Math.max(left,right);
    }
}
