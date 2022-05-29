// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(h), h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Check left side of tree and right side, if both present then root is the ancestor
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val < root.val && q.val< root.val) return lowestCommonAncestor(root.left,p,q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
