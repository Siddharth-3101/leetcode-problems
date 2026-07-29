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
    List<Integer> ans=new ArrayList<>();
    public void inorder(TreeNode root,int k){
        if(root==null){return;}
        inorder(root.left,k);
        ans.add(root.val);
        inorder(root.right,k);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);      
        return ans.get(k-1);   
    }
}