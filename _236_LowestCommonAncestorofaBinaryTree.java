// Time Complexity : o(n) where n is number of nodes
// Space Complexity : o(h) where h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if element is found return true, if both left and right return true then root is ancestor
// handle root to be one of the element
class Solution {// TreeNodes are present
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        lca(root, p, q);
        return lca;
    }

    public boolean lca(TreeNode root, TreeNode p, TreeNode q){

        if(root == null) return false ;

        boolean lcaP = false;
        boolean lcaQ = false;

        if(root.val == p.val){
            lcaP = true;
        }
        if(root.val == q.val){
            lcaQ = true;
        }

        boolean left = lca(root.left, p, q);
        boolean right = lca(root.right, p, q);

        if( (lcaP && lcaQ) ||
           (left && right) ||
            ((lcaP || lcaQ)  && (left || right)) ) {
               lca = root;
          }

         return lcaP || lcaQ || left || right;
    }

    /**************Optimization***************************************************/

    // when you find the element, return root,  you do not need to traverse the subtree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null ;

        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
