// O(n) + O(h) space complexity in worst case
// o(n) time complexity 
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
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.result = 0;
        


        helper(root, k);

        return result;
        
    }

    private void helper(TreeNode root, int k) {
        if(root == null) { return ; }

      
              
        helper(root.left, k);

         queue.add(root.val);

          if(queue.size() ==  k) {
           result = queue.peek();  
        }
       
        helper(root.right, k);

    }
}
