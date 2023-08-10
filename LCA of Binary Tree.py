# Time Complexity : O(N), number of nodes in the tree
# Space Complexity : O(H), height of the tree for the recursive stack
# The code ran on LeetCode

# Recursively traverse over the tree and and keep returning the node we found until a particular step. If there is one node to the left and other node to the right of a node, return the node itself in recursion.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left == None and right == None:
            return None
        elif left == None and right != None:
            return right
        elif left != None and right == None:
            return left
        else:
            return root