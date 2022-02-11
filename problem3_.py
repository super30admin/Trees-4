# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity : O(n)
# Space Complexity: o(h)


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root

        return self.helper(root, p, q)

    def helper(self, root, p, q):
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

