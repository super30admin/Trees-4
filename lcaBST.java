// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // null case
        if (root == null)
            return null;
        // traverse in the tree using BFS
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        // BFS traversal
        while (!qu.isEmpty()) {
            // get current node
            TreeNode curr = qu.poll();
            // check if p and q is lie on the
            // left side or right side
            if (curr.val < p.val && curr.val < q.val) {
                if (curr.right != null) {
                    qu.add(curr.right);
                }
            } else if (curr.val > p.val && curr.val > q.val) {
                if (curr.left != null) {
                    qu.add(curr.left);
                }
            } else {
                return curr;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
}