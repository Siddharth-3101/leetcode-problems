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
    TreeNode prev=null;
    int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        getMinimumDifference(root.left);
        if(prev==null){
            prev=root;
        }
        else{
            minDiff=Math.min(minDiff,Math.abs(root.val-prev.val));
            prev=root;
        }
        getMinimumDifference(root.right);
        return minDiff;
    }
}