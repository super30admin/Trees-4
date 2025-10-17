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
 /*
 * Approach 1: 
    - As the tree is BST, we can do inorder traversal which will give us the sorted array 
    - iterate to the kth index and return the val at that index
    TC: O(n) -> iterate through all the nodes for inorder traversal + iterate through the inorder array
     worst case k = n so 2n which is O(n)
    SC: O(n) -> to store all the treenodes in the inorder array or if we decide to stop early space is O(h)
  */
class Solution {
    int count;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root, k);
        return res.val;
    }

    private void helper(TreeNode root, int k){
        //base
        if(root == null)
            return;
        //logic
        if(res == null)
            helper(root.left, k);
        count++;
        if(count == k)
            res = root;
        if(res == null)
            helper(root.right, k);
    }
}