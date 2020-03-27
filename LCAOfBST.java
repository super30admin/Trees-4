i/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
I would be using the property of Binary Search Tree here
- left subtree of a node contains nodes whose values are lesser than or equal to node's value.
- right subtree of a node contains nodes whose values are greater than node's value.
-Both left and right subtrees are also BSTs.

I would be traversing the tree from the root node.
- If both the nodes p and q are in the right subtree, then I would continue the search with right subtree 
- If both the nodes p and q are in the left subtree, then I would continue the search with left subtree 
- If both step 2 and step 3 are not true, this means weI have found the node which is common to node p's and q's subtrees. and hence I would be returning this common node as the LCA.

Time complexity- O(log n) we are reducing our search space in half everytime as we are going either left or right if we dont find our answer at root
Space Complexity- O(h) where h is the height of the tree.
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //p and q < root, search in a left subtree of root
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
         //p and q > root, search in a right subtree of root
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        //else root is the LCA
        return root;
    }
}
