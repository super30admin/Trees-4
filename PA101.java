
//Leetcode : 235. Lowest Common Ancestor of a Binary Search Tree

//Recursive solution
//Time Complexity: O(n), n is number of nodes in the tree
//Space Complexity; O(n), for the recusive stack
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {      
     return helper(root,p,q);        
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
         if(root == null ) return root;
            if(root.val> p.val &&  root.val>q.val) return helper(root.left,p,q);
            else if(root.val< p.val &&  root.val<q.val) return helper(root.right,p,q);
            else return root;
    
    }
}
//================================================================
//Iterative solution:
//Time Complexity: O(n), n is number of nodes in the tree
//Space Complexity; O(1),
class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return root;
        while(root!=null){
            if(root.val> p.val &&  root.val>q.val) root=root.left;
            else if(root.val< p.val &&  root.val<q.val) root= root.right;
            else return root;
        }
        return null;
        
    }

}