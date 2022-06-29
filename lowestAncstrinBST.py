
'''
time complexity: O(logn)
space complexty: o(logn)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_val =p.val 
        q_val = q.val
        root_val = root.val
        if(p_val < root_val and q_val < root_val):
            return self.lowestCommonAncestor(root.left,p,q)
        elif(p_val > root_val and q_val > root_val):
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root