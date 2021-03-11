"""
236. Lowest Common Ancestor of a Binary Tree
Time Complexity - O(n)
Space Complexity - O(depth of tree)
Here I have used a recursive solution where I have a root val I compare if my root is equal to any of the given node values then return node or else find left and right nodes of tree and if both of them are not none then return root if any one is a non none value return that respective side of node."""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        if root.val == p.val or root.val == q.val:
            return root
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if (left != None and right != None):
            return root
        elif left != None:
            return left
        else:
            return right