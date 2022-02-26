"""
Given a binary search tree (BST), find the 
lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”
"""

# Time Complexity : O(h) h = height of tree
# Space Complexity : O(h)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # null case
        if root is None:
            return root

        # logic
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)

        elif q.val > root.val and p.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)

        else:
            return root