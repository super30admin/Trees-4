//235. Lowest Common Ancestor of a Binary Search Tree
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
        //optimization from previous problem
        //BTS we can decide if to go left or right
        //we already have ans
        if(ans != null || root == null)
            return false;
        if(p == null && q == null)
            return false;
        //Case 1
        // P > R Q > R
        //BOTH ARE RIGHT SIDE
        // P < R Q < R
        //both are left sied
        // P > R Q < R
        //P ON RIGHT Q ON LEFT
        // P < R Q > R
        //P 
        
        TreeNode left = null;
        TreeNode right = null;
        if(p!= null && p.val < root.val){
                  left = p;        
        }    
        if(q!= null && q.val < root.val){
                  right = q;        
        }    
        boolean leftStatus = helper(root.left, left , right);
        left = null;
        right = null;
       
        if(p!= null &&  p.val > root.val){
                  left = p;        
        }    
        if(q!= null && q.val > root.val){
                  right = q;        
        }    
    
        boolean rightStatus = helper(root.right, left, right);
        
        if(leftStatus == true && rightStatus == true){
            ans = root;
            return false;
        }
        if((( p!= null && p == root) ||(q!= null && q==root) ) && rightStatus == true){
            ans = root;
            return false;
        }
        if((( p!= null && p == root) ||(q!= null && q==root) ) && leftStatus == true){
            ans = root;
            return false;
        }
        if( p!= null && root == p){
            return true;                         
        }
        if( q!= null && root == q){    
            return true;
        }
        
        return  rightStatus || leftStatus;
    }
}
