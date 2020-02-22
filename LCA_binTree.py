"""
Time Complexity : O(n)
Space Complexity : O(1) [O(n) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base case
        if not root or p.val == root.val or q.val == root.val:
            return root
        
        # logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        if left:
            return left
        if right:
            return right
        else:
            return None
        