# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root):
            if not root:
                return None
            if root.val == p.val or root.val == q.val:
                return root
            if p.val < root.val and q.val < root.val:
                return helper(root.left)
            if p.val > root.val and q.val > root.val:
                return helper(root.right)
            else:
                return root
        return helper(root)