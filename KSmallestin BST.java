// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
class Solution {
    int k;
    int result = -1;
    private void inorder(TreeNode root){
        if(root == null || this.k == 0) return;
        inorder(root.left);
        k--;
        if(k == 0){
            result = root.val;
            return;    
        }
        inorder(root.right);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        if(root == null) return -1;
        inorder(root);
        return result;
        
        // if(root == null) return -1;
        // Stack<TreeNode> s = new Stack<>();
        // while(!s.isEmpty() || root != null){
        //     while(root!=null){
        //         s.push(root);
        //         root = root.left;
        //     }
        //     root = s.pop();
        //     k--;
        //     if(k == 0) return root.val;
        //     root = root.right;
        // }
        // return -1;
        
    }
}
