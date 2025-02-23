class TreeNode {
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

// TC: O(n) to find the smallest, all the nodes are touched upon.
// SC: O(1) no extra space is used in the following piece of code for computing
// kth smallest element
public class KthSmallestinBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.right = new TreeNode(9);
        System.out.println(kthSmallest(root, 1)); // 1
    }

    static int answer, count;

    private static int kthSmallest(TreeNode root, int k) {
        count = k;
        answer = -1;
        inorder(root);
        return answer;
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        count--;
        if (count == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }

}