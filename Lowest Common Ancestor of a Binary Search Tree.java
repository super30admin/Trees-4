// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return helper(root, p, q);
    }


    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;

        if(p.val == root.val || q.val == root.val) return root;

        else if(p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) return root;

        else if(p.val < root.val && q.val < root.val) return helper(root.left, p, q);

        return helper(root.right, p, q);
    }
}