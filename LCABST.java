//Time complexity: O(log n)
//Space complexity: O(n)

class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        helper(root, p, q);
        return result;
    }

    private void helper (TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return;

        if(root.val < p.val && root.val < q.val)  helper(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) helper(root.left, p, q);
        else {
            result = root;
            return;
        }
    }
}