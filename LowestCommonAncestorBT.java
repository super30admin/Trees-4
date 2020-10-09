/*
 * #236. Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Refer diagram from leetcode
 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.

 */

/*
 * Time Complexity: O (N) -> To traverse through 'N' nodes of a tree
 * 
 * Space Complexity: O (maxDepth) -> Recursive stack will store elements equal to max depth at a time 
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees4;

public class LowestCommonAncestorBT {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	        // #1. Base condition 
	        if(root == null){
	            return null;
	        }
	        
	        // #2. PreOrder traversal
	        
	        // Process root
	        if(p.val == root.val || q.val == root.val){
	            // we found lowest common ancestor
	            return root;
	        }
	        
	        // Process left
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        
	        // Process right
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        
	        // If we found p from left and q from right of a node, meaning its left and rigth not null, then return the root node
	        if(left != null && right != null){
	            return root;
	        }
	        // If we did find p or q from left, return that node to its parent
	        else if(left != null){
	            return left;
	        }
	        // Else block is merge of two conditions
	        // 1. if(right != null) -> We did find p or q from right, return that right node to its parent
	        // 2. if(left == null && right == null) -> Did not find any of p or q from both left and right, return null from any side, doesn't matter
	        else{
	            return right;
	        }
	            
	    }
	 
}
