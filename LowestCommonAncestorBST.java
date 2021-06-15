/*
Desc : we move in the BST with contrainsts deciding the next node for check, once we fail passsing both contraints we will be
left with the position of the LCA.
Time Compelexity : O(n)
Space Complexity : O(h)
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <root.val && q.val<root.val) return lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}
