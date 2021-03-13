/**
  Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

  Input: root = [3,1,4,null,2], k = 1
  Output: 1

  Input: root = [5,3,6,2,4,null,null,1], k = 3
  Output: 3
  
  Iterative stack solution
  Time complexity : O(K + depth of the tree)
  Space complexity : O(maximum depth of the tree)
  Worked on leetcode : YES 
  
  
**/
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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack();
        
        
        if(root == null) return -1;
       
        while(!st.isEmpty() || root != null )  {
            
            
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            
            TreeNode pop = st.pop();
            k--;
            if(k == 0) {
                return pop.val;
            }
            
            pop = pop.right;
            root = pop;
        }
       return -1;
        
    }
}
