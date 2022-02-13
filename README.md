# Trees-4

## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    int result;
    int count =0;
    int k;
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        if(k-1==this.count) {
            result = root.val;
        }
        this.count++;
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inorder(root);
        return result;
    }
}


## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(N/h) h= height of tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }



## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    TreeNode p;
    TreeNode q;
    private TreeNode preorder(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        if(root.val == p.val) return root;
        if(root.val == q.val) return root;
        TreeNode left = preorder(root.left,  p,  q);
        TreeNode right = preorder(root.right,  p,  q);
        if(left != null && right!= null)
            return root; 
        else if( left!= null)
            return left;
        else 
            return right;
        
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p =p;
        this.q = q;
        return preorder(root, p,q);
        
    }
}