""" Time : O(logN)
    Space : O(1)
    Leetcode : Yes
    Explanation : There are 3 cases, root is sandwhich between the p and q ; p, q is less than root; p,q is greater than root. If both are less, go
    search in left tree. If both are greater, go search in right tree.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        
        # 3 cases , p and q are less than root
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        
        # p and q are greater than root
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        
        # root is in between q and p
        return root