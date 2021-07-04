"""
Time Complexity : O(log n)
Space Complexity : O(1) [O(log n) - stack space]
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
    def __init__(self):
        self.LCA = None
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            self.LCA = self.lowestCommonAncestor(root.left, p ,q)
        elif p.val > root.val and q.val > root.val:
            self.LCA = self.lowestCommonAncestor(root.right, p, q)
        else:
            return root
        
        return self.LCA