/*
    LC - 235. Lowest Common Ancestor of a Binary Search Tree
    TC - O(h)
        O(log N) for a balanced BST
        O(N) for a skewed BST in the worst case
    SC - O(1)
    Approach -
        Since it is BST.
        Using BST property - left subtree is less than the root
            right subtree is greater than the root
        given p & q, check if both p & q less than root then ancestor will be in left. 
            move to left; root = root.left;
        p & q greater than root then ancestor will be in right;
            move to right; root = root.right;
        else 
            return root;
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        while(true) {
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}

/*
    LC - 235. Lowest Common Ancestor of a Binary Search Tree
    TC - O(h)
        O(log N) for a balanced BST
        O(N) for a skewed BST in the worst case
    SC - O(h) recursive stack space
    Approach -
        Since it is BST.
        Using BST property - left subtree is less than the root
            right subtree is greater than the root
        given p & q, check if both p & q less than root then ancestor will be in left. 
            call the left recursive call (root.left);
        p & q greater than root then ancestor will be in right;
            call the right recursive call (root.right);
        else 
            return root;
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        return dfs(root, p, q);
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if(root == null) {
            return null;
        }

        // logic
        if(root.val > p.val && root.val > q.val) {
            return dfs(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val) {
            return dfs(root.right, p, q);
        }

        return root;
    }
}