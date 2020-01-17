// Time Complexity - O(n)
// Space Complexity - O(1) if recursive stack is not considered as extra space
// This solution worked on LeetCode

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base Case
        if(root == null || p == root || q == root)   // if p or q is found return that node
            return root;
        //Logic
        TreeNode left = lowestCommonAncestor(root.left,p,q);        
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)       // if both left and right is not null which means p and q is found so return the root
            return root;
        else if(left != null)               // else if left is not null it means one of p or q is found and we return that node
            return left;
        else if(right != null)              // else if right is not null it means one of p or q is found and we return that node
            return right;
        else return null;                       // else return null if none of p or q is found
    }
}
