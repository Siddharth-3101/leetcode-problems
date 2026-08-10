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
class NodeInfo{
    TreeNode node;
    long index;
    NodeInfo(TreeNode node,long index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    long maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        Queue<NodeInfo> q=new LinkedList<>();
        q.add(new NodeInfo(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            long fin=q.peek().index;
            NodeInfo curr=null;
            for(int i=0;i<size;i++){
                curr=q.poll();
                TreeNode temp=curr.node;
                long index=curr.index;
                if(temp.left!=null){
                    q.add(new NodeInfo(temp.left,2*index+1));
                }
                if(temp.right!=null){
                    q.add(new NodeInfo(temp.right,2*index+2));
                }
            }
            long lin=curr.index;
            long width=lin-fin+1;
            maxWidth=Math.max(maxWidth,width);          
        }
        return (int) maxWidth;
    }
}