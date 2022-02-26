"""
Given a binary tree, find the lowest common ancestor (LCA) 
of two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”
"""

# Time Complexity : O(n)
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

        return self.helper(root, p, q)

    def helper(self, root, p, q):
        
        # base
        if root is None or root.val == p.val or root.val == q.val:
            return root

        # logic
        left = self.helper(root.left, p, q)
        right = self.helper(root.right, p, q)

        if left is not None and right is not None:
            return root

        if left is not None:
            return left

        if right is not None:
            return right