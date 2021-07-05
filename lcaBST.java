//Time Complexity:O(N) where N is the number of Nodes.
//Space Complexity:O(1) 
//Approach 1 : Same as I did for LCA binary tree problem.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else{
            return right;
        }
    }
}
//Time Complexity:O(logN) (worst case, when both p and q are either lesser or greater than the root. If one of them is lesser and the other is greater than the root, this algorithm would work in constant time.)where N is the number of Nodes.
//Space Complexity:O(1) 
//Approach 2 : Utilising BST property. If both my p and q are lesser than the root, I'll traverse only through the left half to find the LCA. Else if both my p and q are greater than root, I'll traverse only through the right half to find the LCA. Else, if either of them are lesser or greater than my root, then root is obviously going to be the LCA.
//This code was executed successfully and got accepted on leetcode.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}