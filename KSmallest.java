// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) for the recursion stack

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class KSmallest {
    int count;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;

        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root == null || flag == true){
            return;
        }
        System.out.println(root.val);
        inorder(root.left, k);
        count--;
        if(count == 0){
            result = root.val;
            flag = true;
        }
        inorder(root.right, k);
    }
}
