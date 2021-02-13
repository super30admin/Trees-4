// Time Complexity : O(h), h = height of the recursive stack
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Using the property of binary tree, if p is root, then return the root. Else, if both p and q lie to the left part of the root, then recurse to the left subtree or if both of them lie to the right of the root then recurse to the right subtree. If the p and q lie to left and right respectively, then return the root.

public class LowestCommonAncestorOfABinarySearchTree {

    // Solution 1:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if( p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val ){
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }

    // Solution 2:
    // TreeNode p;
    // TreeNode q;
    
    // TreeNode res;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null) return null;
    //     if(root.left == null || root.right == null) return root;
        
    //     if(q.val < p.val){
    //         TreeNode temp = q;
    //         q = p;
    //         p = temp;
    //     }
        
    //     this.p = p;
    //     this.q = q;

    //     dfs(root);

    //     return res;
    // }
    
    // private void dfs(TreeNode root){
    //     if(root == null) return;
        
    //     if(root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val) ){
    //         res = root;
    //     } else if( p.val < root.val && q.val < root.val){
    //         dfs(root.left);
    //     } else if(p.val > root.val && q.val > root.val ){
    //         dfs(root.right);
    //     }
    // }
}
