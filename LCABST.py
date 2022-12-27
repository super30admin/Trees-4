# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
Time Complexity --> O(n)
Space Complexity --> O(h) where h is the height of the tree
Use Dfs technique to get the LCA
'''

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root==None:
            return None
        if root == p or root==q:
            return root
        left = self.dfs(root.left, p, q)
        right = self.dfs(root.right, p, q)
        if left!=None and right!=None:
            return root
        elif left:
            return left
        else:
            return right
    
    def dfs(self, root, p, q):
        if root!=None:
            if root == p or root == q:
                return root
            left = self.dfs(root.left, p, q)
            right = self.dfs(root.right, p, q)
            if left and right:
                return root
            elif left:
                return left
            else:
                return right
        else:
            return None
        


        
