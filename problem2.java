import com.sun.source.tree.Tree;

// Time Complexity : O(H)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Solved using recursive approach navigating through the BST

public class problem2 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
