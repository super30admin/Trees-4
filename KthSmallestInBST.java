// Time complexity - O(n)
//Space complexity - O(n)
// Solved on leetcode -yes
// Faced any issues - No
// Using inorder traversal and updating the count
class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;  
        }
        inorder(node.right, k);
    }
}
