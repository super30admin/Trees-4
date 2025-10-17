/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
* Approach: 
    - Use the property of BST to see if p and q are greater or smaller than the root
    - if both are smaller, that means LCA is in left subtree of root
    - if both are greater, that means LCA is in right subtree of root
    - if one is smaller and another one is greater, than root itself is the LCA
TC: O(h) -> h is height of the tree if tree is balanced and in worst case h = n
SC: O(1) -> no additional space used
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
    }
}