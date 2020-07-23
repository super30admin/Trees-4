// Time Complexity : O(n) --> where n is the number of elements in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (230): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.empty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}