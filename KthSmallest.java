// Time Complexity : O(k) where k could be as large as n;
// Space Complexity : O(h) where h is the height of the tree;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class KthSmallest {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root==null) return;

        inorder(root.left, k);
        count++;
        if(count==k){
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}