# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using recursion if the p is on left side and q is on the right side of root then the LCA is root
# If both p and q are on left side then LCA will be on left and similary if both are on right side then the LCA will be on right
# Using Iteration for no space check if the root is p or q then return root
# if p and q > root then root = root.right
# Else root = root.left

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        if (root == p or root == q) or (root.val < p.val and root.val > q.val) or (root.val > p.val and root.val < q.val):
            return root
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
#Time - O(H)
#Space - O(H)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        while root:
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root
#Time - O(logn)
#Space - O(1)
        
        