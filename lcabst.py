"""235. Lowest Common Ancestor of a Binary Search Tree
Time Complexity : O(h) height of tree
Space Complexity : O(h) for recursive solution and O(1) for iterative solution"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
       
        if p.val <root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val >root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root"""
                

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        while root:
            if p.val <root.val and q.val<root.val:
                root = root.left
            elif p.val>root.val and q.val>root.val:
                root = root.right
            else:
                return root
            
            
        