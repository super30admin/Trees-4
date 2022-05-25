//sc:o(1) tc:o(h)
class Solution {
    //iterative solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else {
                return root;
            }
        }
    }
}