// Time Complexity :O(n)
// Space Complexity :height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if both p and q are smaller than root, that means they lie on left of root
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        // if both p and q are greater than root, that means they lie on right of root
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        // if none of the above case, that means we found the lowest common ancestor
        return root;
    }

}