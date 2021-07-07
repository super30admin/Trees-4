// Time Complexity : O(k) - k  Could be n selecting the maximum node from the tree
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Appraoch
// Traverse to the left most element in tree which is the least value node
// Keep track of nodes in stack untill the left most node.
// Pop the node from stack (least node) decrement the K value
// Add right node to stack if any
// Move to LEFT of newly added right node and repeat decrementing k.  
// when K reaches 0 return the current node being processed.

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
    int K;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return 0;
        K=k;
        recursive_kthSmallest(root);
        return result.val;
        
//********Iterative*****************
        //IN ORDER TRAVERSAL
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode cursor = root;
//         while(cursor != null){  // Keep adding the left node to the stack
//             stack.add(cursor);
//             cursor = cursor.left;
//         }
        
//         while(!stack.isEmpty()){  //start processing bottom up. Process leaf node in left first from stack.
//             cursor = stack.pop();
//             k--;                  // Since this is least valued node in BST decrement k.
//             if(k == 0 )          // Validate if K is 0, if so return the current node.
//                 return cursor.val;
//             if(cursor.right != null){        
//                 cursor = cursor.right;   // Move to right of leaf node if there is any right
//                 while(cursor != null){     // Process ALL left node to right.   
//                     stack.push(cursor);
//                     cursor = cursor.left;
//                 }
//             }  
//             }
//          return 0;
    }
    
    private void recursive_kthSmallest(TreeNode root){
        //base 
        if(root == null)
            return;
        //Logic
        recursive_kthSmallest(root.left); //Reach end of left
        //Do the processing
        K--;
        if(K==0){
            result = root;
            return;
        }
        recursive_kthSmallest(root.right); //Process the right
    }
       
    }
