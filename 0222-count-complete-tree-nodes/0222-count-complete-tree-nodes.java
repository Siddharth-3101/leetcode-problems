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
    int height(TreeNode root){
        int h=0;
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lefth=height(root.left);
        int righth=height(root.right);
        if(lefth==righth){
            return (int)Math.pow(2,lefth)+countNodes(root.right);
        }
        return (int)Math.pow(2,righth)+countNodes(root.left);
    }
}