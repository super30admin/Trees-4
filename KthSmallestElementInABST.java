//  Time Complexity: O(n)
//  Space Complexity: O(n) for recursive stack

public class KthSmallestElementInABST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = root.val;
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode root, int k) {
        //  base
        if (root == null) {
            return;
        }

        //  logic
        inOrder(root.left, k);

        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        inOrder(root.right, k);
    }
}
