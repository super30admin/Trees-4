# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity : o(LogN)
    # space Complexity : o(N)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root
        return self.helper(root, p, q)

    def helper(self, root, p, q):
        if p == root or q == root:
            return root
        if p.val < root.val and q.val < root.val:
            return self.helper(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.helper(root.right, p, q)
        else:
            return root
