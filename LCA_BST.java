// Time Complexity : O(Log N) we are not visiting all the nodes
// Space Complexity : O(LogN) recusive call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//Use the concept of BST. Left node < root; Right node > root.

//recursive
class Solution {
    //T: O(Log N) we are not visiting all the nodes
    //S: O(LogN) recusive call stack
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        if(p.val < root.val && q.val < root.val){ // if both the nodes are present on left side of root
             return lowestCommonAncestor(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){ // if both the nodes are present on right side of root
            return lowestCommonAncestor(root.right, p, q); 
        }else{ // if one node is on one side and other node is either the root itself or present on the opposite side
            return root;
        }
                    
        
    }
}



//iterative
// Time Complexity : O(Log N) we are not visiting all the nodes
// Space Complexity : O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //iterative version
        
       // if(root == null) return root;
        while(root != null){
            if(p.val<root.val && q.val < root.val){
                root = root.left;
            }else if(p.val>root.val && q.val > root.val){
                root = root.right;
            }else{
                return root;
            } 
        }

        
        return null;
    }
}