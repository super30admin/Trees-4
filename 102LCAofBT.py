"""
    T = O(n)
    maintain the p and q at each node; return root if left != None and right != None
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        if root == None or root == p or root == q: return root
        # logic
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)

        if left != None and right != None: return root
        elif left != None: return left
        elif right != None: return right
        else: return right
