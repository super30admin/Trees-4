class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = helper(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public void helper(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        helper(root.left, arr);
        arr.add(root.val);
        helper(root.right, arr);
        return arr;
    }
}