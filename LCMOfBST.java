//TC = O(h)
// SC = O(h)
// Here we are comparing the p and q with root and moving to either left or right of tree.

class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        int parent = root.val;
        int pval = p.val;
        int qval = q.val;

        if(pval>parent && qval>parent){
            lowestCommonAncestor(root.right, p, q);
        }else if(pval<parent && qval<parent){
            lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}
