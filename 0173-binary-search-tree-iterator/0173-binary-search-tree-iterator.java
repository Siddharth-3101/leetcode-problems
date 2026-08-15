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
class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            stack.push(curr);
            curr=curr.left;
        }
    }
    
    public int next() {
        TreeNode curr=stack.pop();
        if(curr.right!=null){
            TreeNode some=curr.right;
            while(some!=null){
                stack.push(some);
                some=some.left;
            }
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        if(stack.isEmpty()){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */