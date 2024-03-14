'''
TC: O(n) - number of nodes 
SC: O(h) - height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(root):
            if not root:
                return
            
            if (p.val <= root.val and q.val>=root.val) or (p.val >= root.val and q.val<=root.val):
                return root
            
            if p.val < root.val and q.val<root.val:
                return helper(root.left)
            elif p.val > root.val and q.val>root.val:
                return helper(root.right)
        
        return helper(root)