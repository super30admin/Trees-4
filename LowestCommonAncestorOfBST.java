/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
**/

//Recursive approach
// TC: O(N), N -> nodes of the tree
// SC: O(H), H-> height of the tree
// Did it run successfully on Leetcode? : Yes
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        // base ---------for given condition base case is not required
        if ( root == null)
            return null;
        
        // logic 
        if ( p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if ( p.val > root.val && q.val > root.val)
             return lowestCommonAncestor(root.right, p, q);
        else
            return root;
     }
}

// TC: O(N), N -> nodes of the tree
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        while(true)
        {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
    }
}
