/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
     Stack<TreeNode> stack = new Stack<TreeNode>();
    public int KthSmallest(TreeNode root, int k) {
        Helper(root);
        TreeNode n = null;
        
        while(k>0)
        {
            n = stack.Pop();
            k--;
            if(k==0) break;
            Helper(n.right);
        }
        return n.val;
      
    }
    
    private void Helper(TreeNode node)
    {
        while(node!=null)
        {
            stack.Push(node);
            node = node.left;
        }
    }
}
