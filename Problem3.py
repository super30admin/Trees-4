# // Time Complexity : O(n) where n is the number of nodes.
# // Space Complexity : O(1).
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        if root == None or root == p or root ==q:
            return root
        
        # logic
        l = self.lowestCommonAncestor(root.left,p,q)
        r = self.lowestCommonAncestor(root.right,p,q)
        if l != None and r != None:
            return root
        if l == None:
            return r
        else:
            return l
