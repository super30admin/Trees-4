
/**
 * LeetCode Problem 230: Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Time Complexity: O(H + k) where H is the height of the tree
 * Space Complexity: O(H) for the recursion stack
 * If you search inorder and count and if you stop at kth Smallest and return;
 */
public class KthSmallest {

    private int count = 1;
    private int result = -1;
    private boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {

        if (root == null)
            return;

        inorder(root.left, k);
        if (count == k && !found) {
            result = root.val;
            found = true;
            return;
        }

        count++;
        inorder(root.right, k);
    }

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

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode root = kthSmallest.new TreeNode(3);
        root.left = kthSmallest.new TreeNode(1);
        root.right = kthSmallest.new TreeNode(4);
        root.left.right = kthSmallest.new TreeNode(2);

        int k = 1;
        int result = kthSmallest.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        // another test case
        TreeNode root2 = kthSmallest.new TreeNode(5);
        root2.left = kthSmallest.new TreeNode(3);


    }
}