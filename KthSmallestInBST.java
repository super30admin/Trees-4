import java.util.Stack;

public class KthSmallestInBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                System.out.println(root.val);
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

//TC: O(n) - worst case, SC: O(n)
