package Trees4;
// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
import Trees1.TreeNode;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return root;
        if(root.val == p.val)
            return p;
        if(root.val == q.val)
            return q;
        if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
            return root;
        if(root.val > p.val && root.val > q.val)
            return helper(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
            return helper(root.right, p, q);
        return null;
    }

}
