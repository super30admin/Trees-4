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
    // Generally for recusive of trees - saying SC as O(height) better and safer than O(log n) in case of skewed tree.
    // TC is O(log n) only for BST. For normal binary trees, it is O(n)
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // iterative solution - no stack space. So SC is constant. But in recursive, it is O(height of tree)
        if (root == null || p == null || q == null) {
            return null;
        }

        // directly returning TreeNode
        // return recurse1(root, p, q);


        result = null;
        recurse(root, p, q);
        return result;

    }

    private void recurse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }

        if (p.val > root.val && q.val > root.val) {
            recurse(root.right, p, q);
            return;
        } else if (p.val < root.val && q.val < root.val) {
            recurse(root.left, p, q);
            return;
        } 
            result = root;
            return;
    }

    private TreeNode recurse1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val > root.val && q.val > root.val) {
            return recurse1(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return recurse1(root.left, p, q);
        } 
        
        return root;
    }

    // iterative solution - no stack space. So SC is constant. But in recursive, it is O(height of tree)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || p == null || q == null) {
            return null;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur;
    }
}