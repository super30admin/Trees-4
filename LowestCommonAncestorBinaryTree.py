# -*- coding: utf-8 -*-
"""
Created on Fri Feb 21 16:17:48 2020

@author: WELCOME
"""
"""
Lowest Common Ancestor in Binary Tree
Time - O(N)
Space - O(H) where H is the maximum depth
"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        
        def dfs(root):
            if not root:
                return None
            elif root==p or root==q:
                return root
            
            left=dfs(root.left)
            right=dfs(root.right)
            if left and right:
                return root
            elif left and not right:
                return left
            elif right and not left:
                return right
        return dfs(root)
