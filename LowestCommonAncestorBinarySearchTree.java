/*
Problem: Lowest Common Ancestor of a Binary Search Tree (LeetCode 235)
Approach: Use BST property: if both p and q are less than root, LCA is in left subtree; if both greater, it's in right subtree; otherwise root is LCA.
Time Complexity: O(H) where H is tree height.
Space Complexity: O(H) recursion stack (or O(1) if implemented iteratively).
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if(p.val < root.val && q.val< root.val){
            return  lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val && q.val> root.val){
            return  lowestCommonAncestor(root.right, p ,q);
        }
            return root;
    }

}
