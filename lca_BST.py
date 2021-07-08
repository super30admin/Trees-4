"""
// Time Complexity : O(n) //number of elements
// Space Complexity : O(n) //recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
- Given below
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Since we know the tree is a BST, we need not certainly find the placing of p and q since based on the values, we can gauge the direction to go 
        
        Cases
        if p and q both are less than root.val-> return left subtree
        
        if p and q both are greater than root.val -> return right subtree
        
        else return current root        
        """
        if root:
            if p.val < root.val and q.val < root.val:
                return self.lowestCommonAncestor(root.left,p,q)
            if p.val > root.val and q.val > root.val:
                return self.lowestCommonAncestor(root.right,p,q)
            return root