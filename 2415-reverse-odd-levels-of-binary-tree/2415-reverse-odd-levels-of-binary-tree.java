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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return null;
        }
        q.offer(root);
        int LevelNum=0;
        while(!q.isEmpty()){
            int levelSize=q.size();
            List<TreeNode> level=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr=q.poll();
                level.add(curr);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            if(LevelNum%2!=0){
                int left=0;
                int right=level.size()-1;
                while(left<right){
                    int temp=level.get(left).val;
                    level.get(left).val=level.get(right).val;
                    level.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            LevelNum++;
        }
        return root;
    }
}