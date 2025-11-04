# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: 
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def rec(node): 
            if node == None or node == p or node == q: 
                return node

            l = rec(node.left)
            r = rec(node.right)

            if l and r:
                return node
            elif l == None: 
                return r
            elif r == None: 
                return l
            else: 
                return None

        return rec(root)
