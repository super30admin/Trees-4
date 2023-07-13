// Time Complexity :O(log n) where n is the number of nodes in the tree
// Space Complexity :O(log n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

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
public class KthSmallestBST {
    private int count;
    private int value;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return value;
    }

    private void inorder(TreeNode node){

        //base
        if(node == null) return;

        //logic
        inorder(node.left);
        count++;
        if(count == k){
            value = node.val;
            return;
        }
        inorder(node.right);
    }
}
