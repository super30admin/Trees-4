//Time - O(n), SPace - O(h), Approach - DFS- Recursive
class KthSmallestInBST {
    int min, count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        min = root.val;
        inorder(root, k);
        return min;
    }
    private void inorder(TreeNode root, int k) {
        if(root == null) return;

        inorder(root.left, k);
        if(count < k) {
            min = root.val;
            count++;
        }
        inorder(root.right, k);
    }
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}