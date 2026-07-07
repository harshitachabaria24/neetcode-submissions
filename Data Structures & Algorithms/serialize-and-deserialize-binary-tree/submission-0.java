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

public class Codec {
    int index=0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        helperserialize(root,sb);
        return sb.toString();
    }
    public void helperserialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        helperserialize(root.left,sb);
        helperserialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        index=0;
        return helperdeserialize(arr);
    }
    public TreeNode helperdeserialize(String[] arr){
        if(arr[index].equals("N")){
            index++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left=helperdeserialize(arr);
        root.right=helperdeserialize(arr);
        return root;
    }
}
