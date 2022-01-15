// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Logic:
// Check p and q value with the root and break it down into 3 cases
// if both are less than root move to the left
// if both are greater than root move to the right
// else return root

// Iterative approach:
// Time complexity = O(h)
// Space complexity = O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        while (true) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
    }
}

// Recursive approach:
// Time complexity = O(h) : Since its not a balanced binary search tree, its not O(log n)
// Space complexity = O(h) : For stack
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}