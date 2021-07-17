class Solution {

    // Time complexity: O(n)
    // Space complexity: O(n)
    int count  = 0;
    int node;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return node;
    }
    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left, k);
        count++;
        if(count == k){
            node = root.val;
        }
        helper(root.right, k);
    }
}