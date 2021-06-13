"""Time Complexity: O(n)
Space Complexity: O(n)"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None:
            return None
        
        if p.val==root.val or q.val == root.val:
            return root
        
        #left branch
        left = self.lowestCommonAncestor(root.left, p, q)
        
        #right branch
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right:
            return root
        elif left and right == None:
            return left
        else:
            return right