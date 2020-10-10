    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
    Time Complexity for operators : o(nlogn) .. n is the length of the string
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) First sort the backward array on the basis of value. (mlogm)
                    B) Then iterate thru the first array and calculate the target that we have to find in the second array.
                    C) Apply binary search on the second array with target and second array to find the element.
                    D) Once we have index of element, get the  sum and check if it is greater than max. Need to maintain max.
                    E) if sum>max then create new arraylist and add then elemnts into it.
                    F) At the end, return list.
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