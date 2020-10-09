/*
 * #230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

1. The number of elements of the BST is between 1 to 10^4.
2. You may assume k is always valid, 1 <= k <= BST's total elements.

 */


/*
 * Time Complexity: O (N) -> To traverse through 'N' nodes of a tree
 * 
 * Space Complexity: O (maxDepth) -> We are storing elements equal to maxDepth at a time in stack
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees4;

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode13 {
	int val;
	TreeNode13 left;
	TreeNode13 right;
	TreeNode13() {}
	TreeNode13(int val) { this.val = val; }
	TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class KthSmallestElement {
	 public int kthSmallest(TreeNode13 root, int k) {
	        
	        // To keep track if we have found kth smallest element
	        int count = 0;
	        
	        // #1. Base condition 
	        if(root == null){
	            return -1;
	        }
	        
	        // #2. Since we are using Iterative approach, need to create a stack explicitly
	        Stack<TreeNode13> stack = new Stack<TreeNode13>();
	        
	        // #3. Implement Inorder traversal as we want kth samllest element and Inorder traversal gives us sorted order of a BST
	        
	        // e.g: [5,3,6,2,4,null,null,1]
	        // Initially, stack will be empty but root is not null for above example
	        while(!stack.isEmpty() || root != null){
	            
	            // Start Inorder traversal
	            while(root != null){
	                // Push root to the stack and go to left child, repeat until leaf node reached 
	                stack.push(root);
	                root = root.left;   
	            }
	            /*After while loop, we have 5, 3, 2, 1 in stack*/
	            
	            // pop the top from stack
	            TreeNode13 popped = stack.pop();
	            
	            // Increment count as soon as we pop from stack
	            count++;
	            
	            // Check if count is equal to k, meaning we have found our kth smallest
	            // If yes, return the popped element
	            if(count == k){
	                return popped.val;
	            }
	            
	            // If not, go to right of popped element
	            root = popped.right;
	            
	        }
	        
	        return -1; // kth smallest element not found
	        
	    }
	    
}
