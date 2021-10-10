// TC: O(N)
// SC: O(N)
class Solution {
    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        this.list = new ArrayList<>();
        inorder(root);
        return list.get(k - 1);
    }
    private void inorder(TreeNode root) {
        // base
        if(root == null)
            return;
        // logic
        inorder(root.left);
        this.list.add(root.val);
        inorder(root.right);
    }
}