//236. Lowest Common Ancestor of a Binary Tree.java
//TimeComplexity:O(n)
//SpaceComplexity:O(n) skewed tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        helper(root, p, q);
        return ans;
    }
    
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        
        //we already have ans
        if(ans != null || root == null)
            return false;
        
        boolean leftStatus = helper(root.left, p , q);
        boolean rightStatus = helper(root.right, p, q);
        
        if(leftStatus == true && rightStatus == true){
            ans = root;
            return false;
        }
        if((p == root || q==root) && rightStatus == true){
            ans = root;
            return false;
        }
        if((p == root || q==root) && leftStatus == true){
            ans = root;
            return false;
        }
        if(root == p){
            return true;                         
        }
        if( root == q){    
            return true;
        }
        
        return  rightStatus || leftStatus;
    }
}
