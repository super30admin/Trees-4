# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # bottom - up recursion technique
    # TC : O(h)
    # SC : O(h)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root
        leftancestor =  self.lowestCommonAncestor(root.left,p,q)
        rightancestor = self.lowestCommonAncestor(root.right,p,q)
        if leftancestor is None and rightancestor is None:
            return None
        if leftancestor and rightancestor:
            return root
        return leftancestor or rightancestor