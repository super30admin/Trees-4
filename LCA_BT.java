// Time Complexity : O(N)
// Space Complexity : O(H) which can be O(N) in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//if value not found in node, then return null
        //if value found, then return node       
        //if root has both sides returning something, then return the node 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if value not found in node, then return null
        //if value found, then return node       
        //if root has both sides returning something, then return the node 
        
        //T: O(N)
        //S: O(H) which can be O(N) in worst case
        
        //base case
        if(root == null) return root;
        
        //if value found in root, then return node 
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
     //if root has both sides returning something, then return the node 
        if(left != null && right != null){
            return root;
        }
        //if value found, then return node  
        if(left != null) return left;
        //if value found, then return node  
        if(right != null) return right;
        
        return null;
        
    }
}