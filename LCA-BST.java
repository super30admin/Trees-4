/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * TC: O(N) if tree is skewed, O(logN) if tree is balanced
 * SC: O(N) _ O(H)
 * Approach: Discard left and right subtrees by comparing the values of p and q with the current node
 *           This approach works because this is a BST
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge case
        if(root == null || p == null || q == null) {
            return null;
        }
        
        // discard right subtree
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // discard left subtree
        else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // LCA found
        return root;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * TC: O(N)
 * SC: O(1)
 * Approach: Discard left and right subtrees by comparing the values of p and q with the current node
 *           This approach works because this is a BST
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        
        return null;
    }
}
