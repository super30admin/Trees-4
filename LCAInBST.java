// 235.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time - O(n)
//space - O(max depth of bst)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
        {
            return root;
        }
        if(p.val < root.val && q.val < root.val) //both p and q are in left of root
        {
            return lowestCommonAncestor(root.left, p, q); 
        }
        else if(p.val > root.val && q.val > root.val) //both p and q are in right of root
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else //one is in left and other is in right so return root
        {
            return root;
        }
    }
}
