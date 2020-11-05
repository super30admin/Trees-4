// Time Complexity : O(n)  
// Space Complexity : O(n), worst case recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// traverse bst till we find the node value, if we find it, return node, else return null
// for the node where we get left and right values return the node value as it is the lca
// else return the non null node found

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {     
        return helper(root, p, q);
    }
    
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        } 

        if(node.val==p.val || node.val==q.val){
            return node;
        }
        
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return node;
        }
    }
}