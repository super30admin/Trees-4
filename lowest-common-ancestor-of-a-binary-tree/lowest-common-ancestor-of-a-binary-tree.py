# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#Time: O(N)
#Space: O(N)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def backtrack(path,root,v):
            #base
            if root is None:
                return
            if root==v:
                path.append(root)
            
            path.append(root)
            backtrack(path,root.left,v)
