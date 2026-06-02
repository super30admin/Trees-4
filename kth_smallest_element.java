// Time Complexity : O(h + k) where h is tree height because we perform iterative inorder traversal until kth node
// Space Complexity : O(h) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use iterative inorder traversal because inorder traversal of a BST visits nodes in sorted order.
// A stack helps us simulate recursion while traversing left, processing current node, and then moving right.
// We decrement k whenever a node is visited and return the node value when k becomes zero.

class Solution {

    public int kthSmallest(
        TreeNode root,
        int k
    ) {

        // stack for iterative inorder traversal
        Stack<TreeNode> st = new Stack<>();

        while (
            root != null
            ||
            !st.isEmpty()
        ) {

            // move to leftmost node
            while (root != null) {

                st.push(root);

                root = root.left;
            }

            // process node
            root = st.pop();

            k--;

            // kth smallest found
            if (k == 0)
                return root.val;

            // move to right subtree
            root = root.right;
        }

        return -1;
    }
}