/*
  Time complexity: O(n)
  Space complexity: O(h)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int KthSmallest(TreeNode root, int k) {
            int i = 0, solution = 0;
            void DFSinorder(TreeNode node)
            {
                if (node == null) return;
                DFSinorder(node.left);                
                i++;
                if (i == k) solution=node.val;
                DFSinorder(node.right);                
            }
            DFSinorder(root);
            return solution;        
    }
}
