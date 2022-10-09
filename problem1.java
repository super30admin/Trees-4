//Problem1 - https://github.com/ysoni0303/Trees-4

// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, q, p);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, q, p);
        else
            return root;
    }
}
