Time Complexity = O(logn)
Space Complexity = O(h) where h is the height of the tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return root;
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!= null && right !=null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        
        return null;
    }
}