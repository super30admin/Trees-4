# Bottom up recursion approach --
# refer book notes for details
# TC - O(n)
# SC - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None: return None

        if root is None or root is p or root is q: return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left == None and right == None: return None
        elif left is not None and right is None: return left
        elif left is None and right is not None: return right
        else: return root