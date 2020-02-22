//TC : O(n) where n is the number of nodes
//SC : O(n)  where n is the size of list

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     ArrayList<Integer> list = new ArrayList<>();
     public int kthSmallest(TreeNode root, int k) {
         inorderTraversal(root);
         return list.get(k-1);
     }
     
     private void inorderTraversal(TreeNode root){
         if(root == null)
             return;
         
         inorderTraversal(root.left);
         list.add(root.val);
         inorderTraversal(root.right);
     }
 }