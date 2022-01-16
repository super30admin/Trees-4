// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of the count variable 
// we do inorder traversal and when count is 0 we return the answer

class Solution {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        count = k;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        if (count > 0)
            inorder(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use the same logic as above but we implement it in iterative fashion
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            if (k > 0) {
                root = root.right;
            }
        }
        return -1;
    }

}