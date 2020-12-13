# Time:- O(n)
# Space:- O(1)
# Approach:- Using the BST property we know that if both p and q values are greater than root's value we will find the lowest common ancestor on the right of the root else we will find the lowest commmon ancestor on the left, else if
# the root's value is equal to p.value or q.value this is the lowest common ancestor as the a node can be itself's 
# ancestor. 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        elif (p.val<=root.val and q.val>=root.val) or (p.val>=root.val and q.val<=root.val):
            return root
        