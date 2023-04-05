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
    
    //Iterative Approach
    
    //Time Complexity : O(n)
    //Space Complexity : O(h), h= height of the tree
    
//     public int kthSmallest(TreeNode root, int k) {
    
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(root!= null || !stack.isEmpty()){
            
//             while(root != null){
//                 stack.push(root);
//                 root = root.left;
//             }
            
//             root = stack.pop();
//             k--;
            
//             if(k==0){
//                 return root.val;
//             }
//             root = root.right;
//         }
//         return 0;
//     }
    
    
    
    //Recursive Approach 2
    
    //Time Complexity : O(n)
    //Space Complexity : O(h), h= height of the tree
    
    
    int count;
    int ans;
    
    public int kthSmallest(TreeNode root, int k) {
        
        ans = 0;
        count = k;
        
        smallest(root);
        return ans;       
    }
    
    private void smallest(TreeNode node){
        
        if(node == null){
            return;
        }
        
        smallest(node.left);
        
        if(count == 0) return;
        
        count--;
        
        if(count == 0){
         
            ans = node.val;
            return;
        }
        
        smallest(node.right);
    }
    
    
    
     
    //Recursive Approach 1
    
    //Time Complexity : O(n)
    //Space Complexity : O(h), h= height of the tree
    
    
//     int count;
    
//     public int kthSmallest(TreeNode root, int k) {
        
//         count = k;
//         return helper(root);  
//     }
    
//     private int helper(TreeNode root){
        
//         if(root == null) return Integer.MAX_VALUE;
        
//         int left = helper(root.left);
        
//         if(left != Integer.MAX_VALUE) return left;
        
//         count--;
        
//         if(count == 0) return root.val;
        
//         return helper(root.right);    
//     }
}
