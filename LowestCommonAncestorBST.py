# -*- coding: utf-8 -*-
"""
Created on Fri Feb 21 16:19:11 2020

@author: WELCOME
"""
"""
Lowest Common element in BST
Time - O(LogN)
Space - O(H) where H is the height of the tree
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        minVal=min(p.val,q.val)
        maxVal=max(p.val,q.val)
        def dfs(root):
            if not root:
                return None
            if  maxVal>=root.val and minVal<=root.val:
                return root
            elif maxVal>root.val and minVal>root.val:
                return dfs(root.right)
            else:
                return dfs(root.left)
        return dfs(root)
        return None