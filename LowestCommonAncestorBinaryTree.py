# -*- coding: utf-8 -*-
"""
TC: O(H) where H is the height of the tree
SC:recursive stack used O(H) where H is the height of the tree
"""
#Recursive stack approach used

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return
        elif root == p or root == q:
            return root

        else:
            left = self.lowestCommonAncestor(root.left, p, q)
            right = self.lowestCommonAncestor(root.right,p,q)
            if left and right:
                return root
            return left or right