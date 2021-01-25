/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
​
public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val < root.val && q.val < root.val) 
        {
            return LowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val)
        {
            return LowestCommonAncestor(root.right,p,q);
        }
        return root;
        
    }
}
