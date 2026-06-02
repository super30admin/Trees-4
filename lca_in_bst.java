// Time Complexity : O(h) where h is the height of the BST
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use BST properties to locate the Lowest Common Ancestor without exploring unnecessary branches.
// If both nodes are smaller than the current node, we move left; if both are larger, we move right.
// The first node where the paths split or one node equals the current node is the Lowest Common Ancestor.

class Solution {

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {

        while (true) {

            // both nodes lie in left subtree
            if (
                p.val < root.val
                &&
                q.val < root.val
            ) {

                root = root.left;
            }

            // both nodes lie in right subtree
            else if (
                p.val > root.val
                &&
                q.val > root.val
            ) {

                root = root.right;
            }

            // split point or node found
            else {

                return root;
            }
        }
    }
}