# Iterative solution --
# TC - O(n)
# SC - O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None: return root

        pVal = p.val
        qVal = q.val
        node = root

        while node:
            parentVal = node.val

            if parentVal < pVal and parentVal < qVal:
                node = node.right
            elif parentVal > pVal and parentVal > qVal:
                node = node.left
            else:
                # found common ancestor
                return node