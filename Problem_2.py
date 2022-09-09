"""
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem2 Lowest Common Ancestor of a Binary Search Tree
 (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
"""

# Approach - 1
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Time Complexity : O(H), H: height of the tree
        Space Complexity : O(h) 
        """
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root
        

# Approach - 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Iterative approach without using stack
        Time Complexity : O(H), H: height of the tree
        Space Complexity : O(1) 
        """
        while root is not None:
        
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root
        
        
            
        
            
        