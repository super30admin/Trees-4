# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""
time complexity O(N) or height of tree
Space complexity O(1) +recursive stack space


"""
class Solution_lca1:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        if(root is None or root == p or root ==q):
            return root
        
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        
        if(left is not None and right is not None):
            return root
        elif(left is not None):
            return left
        elif(right is not None):
            return right
        else:
            return None