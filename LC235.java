// TC: O(n)
// SC: O(h) h is height of the tree

public class LC235 {
    public TreeNode solve(TreeNode root, int p, int q){
        int currVal = root.val;
        if(currVal>q && currVal>p) return solve(root.left, p, q);
        if(currVal<q && currVal<p) return solve(root.right, p, q);
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = solve(root, p.val, q.val);
        return ans;
    }
}
