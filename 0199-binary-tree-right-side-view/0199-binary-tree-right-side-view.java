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
    public int depth=0;
    List<Integer> ans=new ArrayList<>();
    public void order(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth==ans.size()){
            ans.add(root.val );
        }
        order(root.right,depth+1);
        order(root.left,depth+1);

    }
    public List<Integer> rightSideView(TreeNode root) {
        order(root,depth);
        return ans;
    }
}