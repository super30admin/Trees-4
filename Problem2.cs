// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree - Space taken up by recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I make use of the property of BST - every node in the left subtree of a node contains values lesser than that of the node and every node
in the right subtree of a node contains values greater than the node. I recursively check if values of p and q are less than the 
root, then I recursively check in the left child of the root. Similarly if p and q values are greater than the root, I recursively
check the right subtree. If not, I have arrived at the lowest common ancestor - the point where the two nodes p and q split up in the 
tree which is my final solution.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val)
        {
            return LowestCommonAncestor(root.left, p, q);
        }

        else if(p.val>root.val && q.val>root.val)
        {
            return LowestCommonAncestor(root.right, p, q);
        }

        else
        {
            return root;
        }
    }
}