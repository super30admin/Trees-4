/*
 * #235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

Refer image from leetcode
 
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 

Constraints:

1. All of the nodes' values will be unique.
2. p and q are different and both values will exist in the BST.
	
 */


/*
 * Time Complexity: O (log N) -> We are comparing p and q with root and then moving accordingly to either left or right subtree
 * 					O (N) -> In worst case, in case of skewed tree, we will traverse through all nodes -> skewed tree has just one subtree, either left or right
 * 
 * Space Complexity: O (N) -> maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees4;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // # 1. Base condition 
        if(root == null){
            return null;
        }
        
        // #2. Top-Down Recursion
        
        // 1.  Conditional Statements
        
        /*
        * Since we are given a BST, we can use its property to find lowest common ancestor
        * Property: Elements to the left of root are <= root and elements to the right of root are > root
        * If p and q both are < root, then move to left, no need to explore right subtree
        * If p and q both are > root, then move to right, no need to explore left subtree
        * If p is < root, q > root, or vice versa, that means we are at our lowest common ancestor, return it
        */
        if(p.val < root.val && q.val < root.val){
            // 2. Recursive call on left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){
            // 2. Recursive call on right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            // return the lowest common ancestor
            return root;
        }
        
    }

}
