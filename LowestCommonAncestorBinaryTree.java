// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    TreeNode result;
    int flag = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;

        if(root == p || root == q) return root;

        // We can optimize if we already found out root. We could have found it in the left branch or right branch.
        TreeNode left = helper(root.left, p, q);

        // Already found the root node just return it
        if(flag == 1) return result;

        TreeNode right = helper(root.right, p, q);

        // Already found the root node just return it
        if(flag == 1) return result;

        if(left == null && right == null) return null;

        else if(left != null && right == null) return left;

        else if(left == null && right != null) return right;

        else
        {
            // This means both left and right are not null so they are pointing to some valid nodes in this case only 
            // the root node could be it's parent. So save  the parent and keep on returning the parent because now
            // we don't have to traverse the remaining tree.

            flag = 1;
            result = root;

            return result;
        }
    }
}
