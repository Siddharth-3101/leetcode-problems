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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int rootidx=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                rootidx=i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        int[] leftIn = new int[rootidx];
        int[] rightIn = new int[inorder.length-rootidx-1];
        int[] leftPre=new int[leftIn.length];
        int[] rightPre=new int[rightIn.length];
        for(int i=0;i<rootidx;i++){
            leftIn[i]=inorder[i];
        }
        for(int i=rootidx+1;i<inorder.length;i++){
            rightIn[i-rootidx-1]=inorder[i];
        }
        for(int i=0; i<leftPre.length; i++){
            leftPre[i] = preorder[i + 1];
        }
        for(int i=leftPre.length+1;i<preorder.length;i++){
            rightPre[i-leftPre.length-1]=preorder[i];
        }
        root.left=buildTree(leftPre,leftIn);
        root.right=buildTree(rightPre,rightIn);
        return root;
    }
}