// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - Iterative Recursion
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if (k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach -
class Solution {
    int count = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;

    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        count--;
        if (count == 0)
            res = root.val;
        helper(root.right);
    }
}