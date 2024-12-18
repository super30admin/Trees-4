/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Approach : Using the definition of BST. Recursion Approach
// Time : O(logn) # one half of search is eliminated at every recursive call
// Space : O(h) # height of Binary Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
            // takes care of below two scenarios
            // p.val is < root .val and q.val > root.val and vice versa
            // if p.val or q.val == root --> root is my one of the node
        }
    };
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Approach : Using the definition of BST. Iterative Approach
// Time : O(logn) # one half of search is eliminated at every recursive call
// Space : O(1) 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
                // takes care of below two scenarios
                // p.val is < root .val and q.val > root.val and vice versa
                // if p.val or q.val == root --> root is my one of the node
            }
        }
        return null;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Approach : Using the definition of BST. Iterative Approach
// Time : O(logn) # one half of search is eliminated at every recursive call
// Space : O(1) 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) { // if it is a valid BST
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
                // takes care of below two scenarios
                // p.val is < root .val and q.val > root.val and vice versa
                // if p.val or q.val == root --> root is my one of the node
            }
        }
        // return null;
    }
}