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
    Map<Integer,Integer> hmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hmap = new HashMap<>();
        int n = inorder.length;
        for(int i = 0;i < n;i++){
            hmap.put(inorder[i] , i);
        }
        return buildTreeHelper(preorder , inorder , 0 , n - 1, 0 , n - 1);
    }

    TreeNode buildTreeHelper(int[] pre,int[] in,int preStart , int preEnd,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = hmap.get(pre[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(pre,in,preStart + 1,preStart + numsLeft,inStart,inRoot - 1);
        root.right = buildTreeHelper(pre,in,preStart + numsLeft + 1,preEnd,inRoot + 1,inEnd);
        return root;
    }
}