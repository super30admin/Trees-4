# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return 
        return self.dfs(root , p , q)

    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        
        if(p.val < root.val and q.val < root.val):
            return self.dfs(root.left , p , q)
        elif(p.val > root.val and q.val > root.val):
            return self.dfs(root.right , p , q)
        else: 
            return root
        
        