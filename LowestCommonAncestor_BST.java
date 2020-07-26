/**
 * Algo: If p,q are lying on the left of the root or both are on the right call recursively on respective sides
 *         else if both are lying on either side of the root the return the root as that will eb the lowest common ancestor
 * Time: O(log n) n nodes int the tree
 * Space: O(log n) recursive stack
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return root;

        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p,q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p,q);
        else return root;
    }
}