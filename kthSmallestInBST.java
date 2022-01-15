// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Time Complexity = O(n)
// Space Complexity = O(h)
// Recursive approach : Do an inorder traversal for sorting in ascending order, and check k value to return the result
class Solution {
    int count, result;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        count=k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        count--;
        if (count == 0) {
            result=root.val;
            return;
        }
        if(count > 0) {
            inorder(root.right);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(h)
// Iterative approach : Do an inorder traversal for sorting in ascending order, and check k value to return the result
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {
            // traverse all the way to the left, while adding the nodes to the stack
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            // pop the node and decrement k
            root = st.pop();
            k--;

            // if k==0, you found the element
            if (k == 0) {
                return root.val;
            }

            // traverse the right part
            root = root.right;
        }

        return -1;  // code won't reach this point
    }
}