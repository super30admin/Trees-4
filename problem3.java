//Problem3 - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem3 {
    int count;
    int result;
    boolean flag;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        if (!flag)
            inorder(root.left);
        count--;
        if (count == 0) {
            flag = true;
            result = root.val;
        }

        if (!flag)
            inorder(root.right);

    }
}
