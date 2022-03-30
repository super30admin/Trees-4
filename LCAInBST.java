/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 // if p/q <= root >= p/q root is the ans
 // if p/q on the left of root then move left side
 // if p/q on the right of root then move right side.
 
 TC - O(N) where N is the number of nodes in a tree.
 SC - O(H) where H is the height of the tree in the case of skewed tree with last 2 nodes are
 P & Q respectively.
 
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (p.val == root.val || q.val == root.val)
        {
            return root;
        }
        
        if (p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
}
