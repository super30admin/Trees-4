/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class KthSmallestBST {

    // TC:O(H) SC:O(n)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }

}
