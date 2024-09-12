//230. Kth Smallest Element in a BST.java
//TimeComplexity:O(k)
//SpaceComplexity:O(logn)



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
    int ans = 0;
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        //approach
        //in-order traversal 
        //count till k and return
         counter = k;
         helper(root);
         return ans;
    }
    
    public void helper(TreeNode root){
        if(root == null)
            return;
        if(counter > 0){    
            helper(root.left);
            if(counter == 1){
                ans = root.val;    
            }
            counter--;
             
            helper(root.right);
            
        }
        
    }
}
