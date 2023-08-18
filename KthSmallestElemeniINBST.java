// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h) -> height of the tree -> for recursive stack
// Did this code successfully run on Leetcode : Yes


public class KthSmallestElemeniINBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root,k);
        return result;
    }

    public void helper(TreeNode root, int k)
    {
        if(root == null) return;
        helper(root.left,k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        helper(root.right,k);
    }
}
