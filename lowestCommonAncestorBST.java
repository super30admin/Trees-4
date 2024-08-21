/**
 * Time Complexity: O(h), where h is the height of the binary search tree (BST). 
 * The function traverses the tree from the root to the target nodes, potentially 
 * reaching a depth of h. In the worst case, this traversal might involve going from 
 * the root to a leaf, which takes O(h) time.

 * Space Complexity: O(h), where h is the height of the BST. 
 * The space complexity is due to the recursive call stack. In the worst case, 
 * the recursion depth can go up to the height of the tree, which is O(h).
 */


class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are smaller than root, LCA must be in the left subtree
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than root, LCA must be in the right subtree
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If neither of the above cases are true, then root is the LCA
        else {
            return root;
        }
    }

}
