"""
if both p and q are less than root, search left, i
if both p and q are greater than root, search right
else root is the lca, return
TC: O(H)
SP: O(H)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val < p.val and root.val< q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        if root.val > p.val and root.val>q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        return root