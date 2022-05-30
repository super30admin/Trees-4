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
class KthSmallestElementInABST {
    int result, cnt;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        cnt = k;
        result = -1;
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        if(root == null) return;
        
        if(result == -1){
            inorder(root.left, k);
        }
        cnt--;
        if(cnt == 0){
            result = root.val;
        }
        if(result == -1){
            inorder(root.right, k);
        }
    }
}

//time complexity O(n)
//space complexity O(h)