//sc is O(h);
//tc is O(h);
class Solution {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        result = -1;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            count++;

            if (count == k) {
                return root.val;
            }

            root = root.right;

        }

        return result;

    }

}