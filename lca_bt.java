i//Time Complexitly: O(n)
//Space Complexity : O(1)


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case
        if(root==null||p==root||q==root) return root;
        
        //Logic
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
}
