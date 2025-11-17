# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.res = None
        def dfs(root):
            if not root:
                return 0
            
            f = 0
            if p == root or q == root:
                f = 1
            
            l = dfs(root.left)
            r = dfs(root.right)

            if l+r+f >= 2:
                self.res = root

            return l or r or f
        
        dfs(root)
        return self.res

