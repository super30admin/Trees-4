// Time Complexity : O(h)
// Space Complexity : O (h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * We traverse the entire tree based on which side of the tree the values could be present on.
 * 1 - If both p and q are greater than q, then the roots lie on the right side.
 * 2 - If both p and q are lesser than q, then the roots lie on the left side.
 * 3 - Else if either p or q is equal to the root, then return the root simply as the LCA
 */

public class BSTLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else
            return root;
    }
}
