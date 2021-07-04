  
# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(n) (Recursion stack is called n times)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - There are only three cases possible, first p and q both are on left side, second p and q both are on right side.
# - In third case we found our ancestor.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#       Check if root's value is less than p and q, than go to left child.
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p , q)
#       Check if root's value is greater than p and q, than go to right child.
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
#       In else case we found our node so return it.
        else:
            return root
