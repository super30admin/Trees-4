# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.res=0
        
        def lca(root):
            if root is None or root.val==p.val or root.val==q.val:
                return root
            
            l=lca(root.left)
            r=lca(root.right)
            
            if l and r:
                return root
            
            if l is not None:
                return l
            
            if r is not None:
                return r
            
            return None
        
        
        
        return lca(root)
            