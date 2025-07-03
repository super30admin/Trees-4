# Time Complexity : O(h)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Ensure p's value is less than q's value for easier comparison
        if p.val > q.val:
            p, q = q, p
        current = root
        while current:
            if q.val < current.val:
                current = current.left
            elif p.val > current.val:
                current = current.right
            else:
                return current
        