    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
    Time Complexity for operators : o(n) .. n node in tree
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 1. Add into minheap and pop till k = 0
        # Optimized approach: 
                              
            # 1. 
                    A) Do inorder traversal as it gives Sorted order of an BST
                    B) Add all the left and thenstart popiing while popping decrease k if k == 1 return that node
                        we foound our element.
                    C) iif not then move to right of the inserted node.
    */  

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


// Recursive Approach

// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public int kthSmallest(TreeNode root, int k) {
        
//         if(root == null)
//             return -1;
        
//         inorder(root);
//         return list.get(k-1);
//     }
    
//     public void inorder(TreeNode root){
        
//         if(root == null)
//             return;
        
//         inorder(root.left);
//         list.add(root.val);
//         inorder(root.right);
//     }
// }



// more oprimized one

class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            
            TreeNode popped = stack.pop();
            
            if(k==1)
                return popped.val;
            
            k--;
            
            root = popped.right;
        }
        
        return -1;
    }
}