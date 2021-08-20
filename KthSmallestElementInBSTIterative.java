// TC: O(logn) if tree is balanced
// SC: O(logn) if tree is balanced
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
