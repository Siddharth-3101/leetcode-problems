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
    HashMap<Integer, Integer> map = new HashMap<>();
    int pre = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] postorder,int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        if (postStart == postEnd) {
            return root;
        }
        int leftRoot = preorder[pre];
        int index = map.get(leftRoot);
        root.left = build(preorder, postorder,postStart, index);
        root.right = build(preorder, postorder,index + 1, postEnd - 1);
        return root;
    }
}