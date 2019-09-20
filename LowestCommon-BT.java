/*Time Complexity : O(N);
Space Complexity : O(1) // recursive stack space.
Did it run on LeetCode : Yes
Any Problems : No
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        
        else if(left!=null) return left;
        else if(right!=null) return right;
        
        return null;
        
        
    }
}