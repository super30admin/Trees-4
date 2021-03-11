"""
235. Lowest Common Ancestor of a Binary Search Tree
Time Complexity - O(n)
Space Complexity - O(depth of tree)
This is a recurssive solution where we will check if root is None return None
Check if root val is equal to p or q values, return root
else check if p and q values satisfy binary search tree conditions if yes return root
if both the values are less than root then change root to root.left
if both the values are greater than root return root.right
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        if root.val == p.val or root.val == q.val:
            return root
        if p.val < root.val and q.val > root.val or q.val < root.val and p.val > root.val:
            return root
        elif p.val < root.val and q.val < root.val:
            return lowestCommonAncestor(root.left, p, q)
        else:
            return lowestCommonAncestor(root.right, p, q)
        
        