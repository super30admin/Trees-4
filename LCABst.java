/*TC, SC O(N)
 * */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if both the elements lie to the left, recurse on left
        // else if both the elements lie to the right, recurse on right
        // else , the nodes are on either side of the node, return root

        // base
        //if (root == null) return null;

        // logic

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p,q);
        } else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p,q);
        } else {
            return root;
        }

    }
}
