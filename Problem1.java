public class Problem1 {
    public class TreeNode {
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

    class Solution {
        int count, result;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return 0;
            count = k;

             helper(root);
            return result;
        }

        private void helper(TreeNode root) {
            //base case
            if (root == null) return;
            //logic

            helper(root.left);
            count--;
            if (count == 0) {
                result = root.val;
            }
            if (count != 0) {
                helper(root.right);
            }
        }
    }
}
