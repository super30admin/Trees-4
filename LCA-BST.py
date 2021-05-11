# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        if (p.val < root.val < q.val) or (q.val < root.val < p.val) or (root.val == p.val) or (root.val == q.val):
            return root
        if q.val > root.val and p.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        if q.val < root.val and p.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)