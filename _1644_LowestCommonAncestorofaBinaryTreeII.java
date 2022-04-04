// Time Complexity : o(n) where n is number of nodes
// Space Complexity : o(h) where h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if element is found return true, if both left and right return true then root is ancestor
// handle root to be one of the element
class Solution { // TreeNodes may not be present

    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        helper(root, p, q);
        return lca;
    }


    public boolean helper(TreeNode root, TreeNode p, TreeNode q){

        if( root == null) return false;

        boolean lcaP = false;
        boolean lcaQ = false;
        if(root == p){
            lcaP = true;
        }

        if(root == q){
            lcaQ = true;
        }

        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);

        if( (lcaP && lcaQ) ||
            ((lcaP || lcaQ) && (left || right)) ||
            (left && right) ){
                 lca = root;
        }


        return lcaP || lcaQ || left || right;

    }

}
