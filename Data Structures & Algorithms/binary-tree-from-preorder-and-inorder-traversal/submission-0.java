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
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int[] inorder,int instart,int inend){
        if(instart>inend)
        return null;
        TreeNode root=new TreeNode(preorder[preindex]);
        preindex++;
        int index=instart;
        while(inorder[index]!=root.val){
            index++;
        }
        root.left=build(preorder,inorder,instart,index-1);
        root.right=build(preorder,inorder,index+1,inend);
        return root;
    }
}
