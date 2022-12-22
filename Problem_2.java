// Time Complexity : O(n)
// Space Complexity : O(1) -- for iterative method and O(height) for recursive method
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//if p,q less than root, move left, if both greater than root, move right
//if one less than or equal to root and one greater than or equal to root, return root

//235. Lowest Common Ancestor of a Binary Search Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        } 
        return null; 
    }
}

//Recursive Method
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return null;
//         if(p.val < root.val && q.val < root.val){
//             return lowestCommonAncestor(root.left, p, q);
//         }
//         else if(p.val > root.val && q.val > root.val){
//             return lowestCommonAncestor(root.right, p, q);
//         }
//         else{
//             return root;
//         }
        
//     }
// }