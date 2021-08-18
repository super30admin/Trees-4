// Time Complexity : O(logn)
// Space Complexity : (stack space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Recursive Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Base case : if root == null, return null
        if(root == null) {
            return null;
        }
        
        //if both p & q greater than root, LCA lies in right side
        //recursively call method on right side
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //if both p & q less than root, LCA lies in left side
        //recursively call method on left side
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        //else, if either p/q = root / p >= root && q <= root / p <= root && q >= root
        //then return root, as root is LCA
        return root; 
    }
}


//////////////////////


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Iterative Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //while node exists
        while(root != null) {
            //if both p & q greater than root, LCA lies in right side
            //root = root.right
            if(p.val > root.val && q.val > root.val) {
                root = root.right; 
            }
            //if both p & q less than root, LCA lies in left side
            //root = root.left
            else if (p.val < root.val && q.val < root.val) {
                root = root.left; 
            }
            //else, if either p/q = root / p >= root && q <= root / p <= root && q >= root
            //then return root, as root is LCA
            else {
                return root; 
            }
        }
        //never reaches this case as both p & q are valid
        return null;
    }
}
