// Time complexity: O(n)
// Space complexity: O(h)
class Solution {
    private int counter;
    private Integer result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {

        if(root == null) return;
        if(result != null) return;
        helper(root.left, k);

        counter++;
        if(counter == k) {
            result = root.val;
        }
        helper(root.right, k);
    }
}