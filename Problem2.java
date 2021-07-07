//Recursive Solution
// Time Complexity - O(n) where H is the height of the BST
// Space Complexity - O(1) if recursive stack is not considered as extra space and O(H) where H is the height of the tree
//     
// This solution worked on LeetCode
// Since this is a binary search tree, the left side of the root will be smaller than root and the right side tree will be greater than the root. So if p and q are less than root, root is traversed to left. And if p and q value are greater than root, then root is traversed to left side. Else root is returned.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(p.val < root.val && q.val < root.val)   
                return  lowestCommonAncestor(root.left, p, q);
            else if(p.val > root.val && q.val > root.val)    
                return  lowestCommonAncestor(root.right, p, q);    
            else    
                return root;
    }
}

// Iterative solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val)   
                root = root.left;
            else if(p.val > root.val && q.val > root.val)   
                root = root.right;
            else return root;
        }   
        return null;
    }
}
