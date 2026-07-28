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
    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    public boolean check(TreeNode root,long index,int total){
        if(root==null){
            return true;
        }
        if(index>=total){
            return false;
        }
        return check(root.left,2*index+1,total) && check(root.right,2*index+2,total);
    }
    public boolean isCompleteTree(TreeNode root) {
        int total=count(root);
        return check(root,0,total);
    }
}