//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
Time: O(H) where H is the height of the tree
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LCAofBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);

        while (root != null) {
            if (root.val > large) // p, q belong to the left subtree
                root = root.left;

            else if (root.val < small) // p, q belong to the right subtree
                root = root.right;

            else // Now, small <= root.val <= large -> This root is the LCA between p and q
                return root;
        }
        return null;

    }

}
