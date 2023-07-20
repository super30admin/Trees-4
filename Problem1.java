class Solution {
    int count;
    int result;
    Boolean flag;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        flag = false;
        recur(root, k);
        return result;
    }

    public void recur(TreeNode root, int k) {
        if (root == null)
            return;
        recur(root.left, k);
        count -= 1;
        if (count == 0 && flag == false) {
            flag = true;
            result = root.val;
        }
        if (flag == false) {
            recur(root.right, k);
        }
        return;
    }
}