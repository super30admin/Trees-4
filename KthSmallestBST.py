# -*- coding: utf-8 -*-
"""
Created on Fri Feb 21 16:38:45 2020

@author: WELCOME
"""
"""
Kth Smallest in BST
Time - O(N)
Space - O(H)
"""
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        val=-1
        def dfs(root):
            nonlocal val
            nonlocal k
            if not root:
                return 
            dfs(root.left)
            k-=1
            if k==0:
                val=root.val
            return dfs(root.right)
        dfs(root)
        return val