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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }

    public boolean helper(TreeNode root , int target){
        if(root == null){
            return false;
        }
        if(root.val == target && (root.left == null && root.right == null)){
            return true;
        }
        return helper(root.left , target - root.val) || helper(root.right , target - root.val);
    }
}