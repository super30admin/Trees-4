# -*- coding: utf-8 -*-
"""
TC: O(H) where H is the binary tree height
SC: O(1) as no extra space used
"""
'''
We know that p != q and p and q exist in BST we initialize left and right borders. 
While root.val is not within the borders we 
reassign our root as root.left if right border is lower than 
the current root.val and root.right otherwise. 
Return root in the end.'''

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
		# Intialize our borders
        left, right = (p.val, q.val) if p.val < q.val else (q.val, p.val)
        
        while not (left <= root.val <= right):
            root = root.left if right < root.val else root.right
            
        return root