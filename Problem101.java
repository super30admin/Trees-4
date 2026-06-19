// Time Complexity : O(n)
// Space Complexity : O(h)

class Solution {
    int count = 0;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result.val;
    }

    private void helper(TreeNode root, int k){
        //base
        if(root == null) return;

        //logic
        if(result == null) {
            helper(root.left, k);
        }

        count++;
        if(count == k) {
            result = root;
        }

        if(result == null) {
            helper(root.right, k);
        }
    }
}
