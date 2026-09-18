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
    public int minDepth(TreeNode root) {
        return helper(root);
    }
    int helper(TreeNode root){
        if(root == null){
            return 0;
        } 
        int l = helper(root.left);
        int r = helper(root.right);
        if(l == 0 && r != 0){
            return 1 + r;
        }
        if(l != 0 && r == 0){
            return 1 + l;
        }
        return 1 + Math.min(l , r);
    }
}