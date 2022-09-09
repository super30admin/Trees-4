# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # check if root is null or if we found any of p or q, then simply return the root
        if root == None or p == root or q == root:
            return root
        
        # maintain the left and right for each node
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # if left is null and right is not null, then return the value as right
        if left == None and right != None:
            return right
        # if left is not value, and right is null, then return the value as left
        elif left != None and right == None:
            return left
        # if both the left and right are null, then simply return null
        elif left == None and right == None:
            return None
        else:
        # else when both has some values, then return the root
            return root
