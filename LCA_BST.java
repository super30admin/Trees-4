/**
 * Time Complexity : O(log N) where n = number of nodes
 * Space Complexity : O(h) where h = Height of the tree
 */
public class LCA_BST {
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
        {
            return root;
        }

    }
}