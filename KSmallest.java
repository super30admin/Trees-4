/**Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* TC O(N) SC O(H) where H is height of the tree
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stk = new Stack<TreeNode>();
        //stk.add(root);
        while(root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            k --;
            if (k==0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
