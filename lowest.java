class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //recursive
        /*
        if(root.val<p.val && root.val<q.val)return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val && root.val>q.val)return lowestCommonAncestor(root.left,p,q);
        else return root;
        */

        //iterative
        while (true) {
    if(p.val < root.val && q.val < root.val) 
        root = root.left;
    else if(p.val > root.val && q.val > root.val) 
        root = root.right;
    else 
        return root;
}
    }
}